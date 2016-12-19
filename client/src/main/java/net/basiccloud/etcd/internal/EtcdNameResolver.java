package net.basiccloud.etcd.internal;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import io.grpc.Attributes;
import io.grpc.NameResolver;
import io.grpc.ResolvedServerInfo;
import io.grpc.Status;
import io.grpc.internal.LogExceptionRunnable;
import io.grpc.internal.SharedResourceHolder;

import net.basiccloud.etcd.internal.EtcdAddressParser.IpPortPair;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.concurrent.GuardedBy;

import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Etcd NameResolver Implementation.
 *
 * <p>Difference to DnsNameResolver, the implementation can handle multiple addresses in one line like:
 *
 * <p>etcd://192.168.0.1:2379,192.168.0.2:2379,192.168.0.3:2379
 *
 * <p>You can also use host, this resolver will act like DnsNameResolver to parse the host to ip address：
 *
 * <p>etcd://etcd.basiccloud.net:2379
 */
class EtcdNameResolver extends NameResolver {

    private static Logger logger = LoggerFactory.getLogger(EtcdNameResolver.class);

    private final String authority;
    private final String etcdAddresses;

    private final SharedResourceHolder.Resource<ScheduledExecutorService> timerServiceResource;
    private final SharedResourceHolder.Resource<ExecutorService> executorResource;

    @GuardedBy("this")
    private boolean shutdown;
    @GuardedBy("this")
    private ScheduledExecutorService timerService;
    @GuardedBy("this")
    private ExecutorService executor;
    @GuardedBy("this")
    private ScheduledFuture<?> resolutionTask;
    @GuardedBy("this")
    private boolean resolving;
    @GuardedBy("this")
    private Listener listener;

    private final Runnable resolutionRunnable = new ResolutionRunnable();
    private final Runnable resolutionRunnableOnExecutor = () -> {
        synchronized (EtcdNameResolver.this) {
            if (!shutdown) {
                executor.execute(resolutionRunnable);
            }
        }
    };

    EtcdNameResolver(String etcdAddresses,
                     SharedResourceHolder.Resource<ScheduledExecutorService> timerServiceResource,
                     SharedResourceHolder.Resource<ExecutorService> executorResource) {
        checkArgument(!Strings.isNullOrEmpty(etcdAddresses), "etcdAddresses should not be null or empty");
        checkNotNull(timerServiceResource, "timerServiceResource should not be null");
        checkNotNull(executorResource, "executorResource should not be null");
        this.timerServiceResource = timerServiceResource;
        this.executorResource = executorResource;

        // Must prepend a "//" to the name when constructing a URI, otherwise it will be treated as an
        // opaque URI, thus the authority and host of the resulted URI would be null.
        URI nameUri = URI.create("//" + etcdAddresses);
        authority = checkNotNull(nameUri.getAuthority(),
                "nameUri (%s) doesn't have an authority", nameUri);
        this.etcdAddresses = checkNotNull(etcdAddresses, "etcdAddresses　should not be null");
    }

    @Override
    public final String getServiceAuthority() {
        return authority;
    }

    @Override
    public final synchronized void start(Listener listener) {
        try {
            Preconditions.checkState(this.listener == null, "already started");
            timerService = SharedResourceHolder.get(timerServiceResource);
            executor = SharedResourceHolder.get(executorResource);
            this.listener = checkNotNull(listener, "listener");
            resolve();
        } catch (Exception t) {
            logger.error("fail to start name resolver", t);
            throw new EtcdNameResolverException("fail to start name resolver", t);
        }
    }

    @Override
    public final synchronized void refresh() {
        Preconditions.checkState(listener != null, "not started");
        resolve();
    }


    @GuardedBy("this")
    private void resolve() {
        if (resolving || shutdown) {
            return;
        }
        executor.execute(resolutionRunnable);
    }

    @Override
    public final synchronized void shutdown() {
        if (shutdown) {
            return;
        }
        shutdown = true;
        if (resolutionTask != null) {
            resolutionTask.cancel(false);
        }
        if (timerService != null) {
            timerService = SharedResourceHolder.release(timerServiceResource, timerService);
        }
        if (executor != null) {
            executor = SharedResourceHolder.release(executorResource, executor);
        }
    }

    private class EtcdNameResolverException extends RuntimeException {
        EtcdNameResolverException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    private class ResolutionRunnable implements Runnable {

        @Override
        public void run() {
            Listener savedListener;
            synchronized (EtcdNameResolver.this) {
                // If this task is started by refresh(), there might already be a scheduled task.
                if (resolutionTask != null) {
                    resolutionTask.cancel(false);
                    resolutionTask = null;
                }
                if (shutdown) {
                    return;
                }
                savedListener = listener;
                resolving = true;
            }

            try {
                List<IpPortPair> ipPortPairList;
                try {
                    ipPortPairList = EtcdAddressParser.parse(etcdAddresses, 2379);
                } catch (UnknownHostException e) {
                    synchronized (EtcdNameResolver.this) {
                        if (shutdown) {
                            return;
                        }
                        // Because timerService is the single-threaded GrpcUtil.TIMER_SERVICE in production,
                        // we need to delegate the blocking work to the executor
                        resolutionTask = timerService.schedule(
                                new LogExceptionRunnable(resolutionRunnableOnExecutor), 1, TimeUnit.MINUTES);
                    }
                    savedListener.onError(Status.UNAVAILABLE.withCause(e));
                    return;
                }
                List<ResolvedServerInfo> servers = new ArrayList<>();
                if (ipPortPairList != null) {
                    for (IpPortPair ipPortPair : ipPortPairList) {
                        InetSocketAddress inetSocketAddress = new InetSocketAddress(
                                ipPortPair.getIp(), ipPortPair.getPort());
                        servers.add(new ResolvedServerInfo(inetSocketAddress, Attributes.EMPTY));
                    }
                }
                savedListener.onUpdate(Collections.singletonList(servers), Attributes.EMPTY);
            } finally {
                synchronized (EtcdNameResolver.this) {
                    resolving = false;
                }
            }
        }
    }
}

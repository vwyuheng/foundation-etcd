package net.basiccloud.etcd.internal;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.annotation.Nullable;

import io.grpc.Attributes;
import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;
import io.grpc.internal.SharedResourceHolder;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Provide standard gRPC NameResolver for etcd (version 3.*).
 */
public class EtcdNameResolverProvider extends NameResolverProvider {

    public static final String ETCD_SCHEME = "etcd";
    private static Logger logger = LoggerFactory.getLogger(EtcdNameResolverProvider.class);


    private static SharedResourceHolder.Resource<ScheduledExecutorService> timerServiceResource =
            new SharedResourceHolder.Resource<ScheduledExecutorService>() {
                @Override
                public ScheduledExecutorService create() {
                    return Executors.newScheduledThreadPool(1, new ThreadFactoryBuilder().setDaemon(true).setNameFormat
                            ("etcd-resolver-timerService-").build());
                }

                @Override
                public void close(ScheduledExecutorService instance) {
                    instance.shutdownNow();
                }
            };


    private static SharedResourceHolder.Resource<ExecutorService> executorResource =
            new SharedResourceHolder.Resource<ExecutorService>() {

                @Override
                public ExecutorService create() {
                    return Executors.newCachedThreadPool(new ThreadFactoryBuilder().setDaemon(true).setNameFormat
                            ("etcd-resolver-executor-%d").build());
                }

                @Override
                public void close(ExecutorService instance) {
                    instance.shutdownNow();
                }
            };


    @Override
    protected boolean isAvailable() {
        // always available
        return true;
    }

    @Override
    protected int priority() {
        // set to default 5
        return 5;
    }

    @Override
    public String getDefaultScheme() {
        return ETCD_SCHEME;
    }

    @Nullable
    @Override
    public NameResolver newNameResolver(URI targetUri, Attributes params) {
        if (!ETCD_SCHEME.equals(targetUri.getScheme())) {
            // only resolve scheme starts with "etcd://"
            return null;
        }

        final String authority = targetUri.getAuthority();
        checkNotNull(authority, "uri content should not be empty");

        logger.info("Etcd NameResolver is activated");
        return new EtcdNameResolver(authority, timerServiceResource, executorResource);
    }
}

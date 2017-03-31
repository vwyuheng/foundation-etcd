package net.basiccloud.etcd.registry.internal;

import com.google.common.base.Strings;
import com.google.protobuf.ByteString;

import com.coreos.etcd3.api.WatchCreateRequest;
import com.coreos.etcd3.api.WatchGrpc;
import com.coreos.etcd3.api.WatchRequest;
import com.coreos.etcd3.api.WatchResponse;

import net.basiccloud.etcd.registry.internal.entity.KeyUtil;
import net.basiccloud.registry.ServiceInstance;
import net.basiccloud.registry.ServiceRegistryClient;
import net.basiccloud.registry.ServiceRegistryConnection;
import net.basiccloud.registry.Version;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import io.grpc.stub.StreamObserver;
import mvccpb.Kv;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * etcd3 implementation of ServiceRegistryClient.
 */
public class ServiceRegistryClientEtcdImpl extends AbstractServiceRegistryEtcdImpl implements ServiceRegistryClient {

    private static Logger logger = LoggerFactory.getLogger(ServiceRegistryClientEtcdImpl.class);
    private static WatchGrpc.WatchStub watchStub;

    /**
     * create service registry client
     *
     * @param connection etcd connection
     */
    public ServiceRegistryClientEtcdImpl(ServiceRegistryConnection connection) {
        super(connection);
        ServiceRegistryConnectionEtcdImpl etcdConnection = (ServiceRegistryConnectionEtcdImpl) connection;
        watchStub = WatchGrpc.newStub(etcdConnection.getManagedChannel());
    }

    @Override
    public List<ServiceInstance> discover(String group, String service) {
        checkArgument(!Strings.isNullOrEmpty(group), "group should not be null or empty");
        checkArgument(!Strings.isNullOrEmpty(service), "service should not be null or empty");
        return discover(group, service, null);
    }

    @Override
    public List<ServiceInstance> discover(String group, String service, Version version) {
        checkArgument(!Strings.isNullOrEmpty(group), "group should not be null or empty");
        checkArgument(!Strings.isNullOrEmpty(service), "service should not be null or empty");

        List<ServiceInstance> serviceInstances = instanceQuery(group, service, version);
        return serviceInstances.stream().filter(
                serviceInstance -> serviceInstance.getData().getWorkMode().isAvailable() &&
                        serviceInstance.getStatus() != null && serviceInstance.getStatus().isOnline()).collect
                (Collectors
                        .toList());
    }

    @Override
    public boolean watch(String group, String service, Version version,
            ClientListener clientListener) {
        StreamObserver<WatchRequest> watch = watchStub.watch(new StreamObserver<WatchResponse>() {
            @Override
            public void onNext(WatchResponse value) {
                if (!value.getCreated() && !value.getCanceled()) {
                    //List<Kv.Event> eventsList = value.getEventsList();
                    //TODO andy on etcd notify do something
                } else {
                    //TODO andy on etcd notify do something
                }
            }

            @Override
            public void onError(Throwable t) {
                logger.error("watch error", t);
            }

            @Override
            public void onCompleted() {
                logger.info("watch onCompleted");
            }
        });

        final String key = KeyUtil.instanceDiscoverBeginKey(group, service);
        final String rangeEnd = KeyUtil.instanceDiscoverEndKey(group, service);
        WatchCreateRequest createRequest = WatchCreateRequest.newBuilder().setKey(
                ByteString.copyFromUtf8(key)).setRangeEnd(
                ByteString.copyFromUtf8(rangeEnd)).build();

        watch.onNext(WatchRequest.newBuilder().setCreateRequest(createRequest).build());
        return true;
    }
}

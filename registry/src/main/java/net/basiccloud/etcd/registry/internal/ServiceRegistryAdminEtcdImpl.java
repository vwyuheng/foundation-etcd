package net.basiccloud.etcd.registry.internal;

import com.coreos.etcd3.api.RangeRequest;
import com.coreos.etcd3.api.RangeResponse;
import net.basiccloud.etcd.registry.internal.entity.KeyUtil;
import net.basiccloud.registry.ServiceInstance;
import net.basiccloud.registry.ServiceRegistryAdmin;
import net.basiccloud.registry.ServiceRegistryConnection;

import java.util.Optional;

/**
 * Etcd3 implementation of ServiceRegistryAdmin.
 */
public class ServiceRegistryAdminEtcdImpl extends AbstractServiceRegistryEtcdImpl implements ServiceRegistryAdmin {

    /**
     * create admin etcd implements with connection
     * @param connection service registry connection
     */
    public ServiceRegistryAdminEtcdImpl(ServiceRegistryConnection connection) {
        super(connection);
    }


    @Override
    public Optional<ServiceInstance> getInstance(String group, String service, String ip, int port) {
        final String instanceDataKey = KeyUtil.instanceDataKey(group, service, ip, port);
        final String instanceStatusKey = KeyUtil.instanceStatusKey(group, service, ip, port);

        RangeRequest rangeRequest = RangeRequest.newBuilder().build();
        RangeResponse rangeResponse = kvBlockingStub.range(rangeRequest);

        return null;
    }
}

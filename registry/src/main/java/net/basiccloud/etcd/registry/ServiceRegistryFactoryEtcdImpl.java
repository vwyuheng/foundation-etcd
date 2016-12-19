package net.basiccloud.etcd.registry;

import net.basiccloud.etcd.registry.internal.ServiceRegistryAdminEtcdImpl;
import net.basiccloud.etcd.registry.internal.ServiceRegistryClientEtcdImpl;
import net.basiccloud.etcd.registry.internal.ServiceRegistryConnectionEtcdImpl;
import net.basiccloud.etcd.registry.internal.ServiceRegistryServerEtcdImpl;
import net.basiccloud.registry.ServiceRegistryAdmin;
import net.basiccloud.registry.ServiceRegistryClient;
import net.basiccloud.registry.ServiceRegistryConnection;
import net.basiccloud.registry.ServiceRegistryFactory;
import net.basiccloud.registry.ServiceRegistryServer;

import java.util.Map;

/**
 * etcd3 implementation of ServiceRegistryFactory.
 */
public class ServiceRegistryFactoryEtcdImpl implements ServiceRegistryFactory {

    @Override
    public String getName() {
        return "etcd";
    }

    @Override
    public int getPriority() {
        return PRIORITY_DEFAULT;
    }

    @Override
    public ServiceRegistryConnection connect(Map<String, String> parameters) {
        return ServiceRegistryConnectionEtcdImpl.buildFromParameters(parameters);
    }

    @Override
    public ServiceRegistryClient getClient(ServiceRegistryConnection connection) {
        return new ServiceRegistryClientEtcdImpl(connection);
    }

    @Override
    public ServiceRegistryServer getServer(ServiceRegistryConnection connection) {
        return new ServiceRegistryServerEtcdImpl(connection);
    }

    @Override
    public ServiceRegistryAdmin getAdmin(ServiceRegistryConnection connection) {
        return new ServiceRegistryAdminEtcdImpl(connection);
    }
}

package net.basiccloud.etcd.registry.internal;

import net.basiccloud.registry.ServiceInstance;
import net.basiccloud.registry.ServiceInstanceData;
import net.basiccloud.registry.ServiceInstanceStatus;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ServiceRegistryServerEtcdImplTest {

    private static ServiceRegistryServerEtcdImpl server;

    private static ServiceInstance serviceInstance;

    @BeforeClass
    public static void setup() {
        ServiceRegistryConnectionEtcdImpl connection = new ServiceRegistryConnectionEtcdImpl("etcd://127.0.0.1:2379");
        connection.connect();
        server = new ServiceRegistryServerEtcdImpl(connection);

        serviceInstance = ServiceInstance.newBuilder()
                .setGroup("Core")
                .setService("UserService")
                .setIp("192.168.0.1")
                .setPort(10800)
                .setData(ServiceInstanceData.newBuilder().setServiceVersion("1.0").setFrameworkVersion("1.0").build())
                .setStatus(ServiceInstanceStatus.newBuilder().asOnline().build())
                .build();
    }

    @Test
    public void register() throws Exception {
        EtcdRegisterId etcdRegisterId = server.register(serviceInstance);
        assertThat(etcdRegisterId.getLeaseId()).isNotNull();
        assertThat(etcdRegisterId.getInstance().getStatus().getLeaseId()).isNotNull();
        assertThat(ServiceRegistryServerEtcdImpl.serviceInstanceMap.size()).isEqualTo(1);
        assertThat(ServiceRegistryServerEtcdImpl.serviceInstanceMap.containsKey(serviceInstance.getId())).isTrue();

        Optional<ServiceInstanceData> serviceInstanceData = server.instanceDataQuery(serviceInstance);
        assertThat(serviceInstanceData.isPresent()).isTrue();
        if (serviceInstanceData.isPresent()) {
            assertThat(serviceInstanceData.get()).isEqualTo(etcdRegisterId.getInstance().getData());
        }

        server.deregister(etcdRegisterId);
        assertThat(ServiceRegistryServerEtcdImpl.serviceInstanceMap.size()).isEqualTo(0);

        Optional<ServiceInstanceStatus> serviceInstanceStatus = server.instanceStatusQuery(serviceInstance);
        assertThat(serviceInstanceStatus.isPresent()).isTrue();
        if (serviceInstanceStatus.isPresent()){
            assertThat(serviceInstanceStatus.get().getLeaseId()).isEqualTo(0);
            assertThat(serviceInstanceStatus.get().isOffline()).isTrue();
        }
    }
}
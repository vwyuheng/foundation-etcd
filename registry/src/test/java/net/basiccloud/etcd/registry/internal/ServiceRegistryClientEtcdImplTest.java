package net.basiccloud.etcd.registry.internal;

import net.basiccloud.registry.ServiceInstance;
import net.basiccloud.registry.ServiceInstanceData;
import net.basiccloud.registry.ServiceInstanceStatus;
import net.basiccloud.registry.Version;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ServiceRegistryClientEtcdImplTest {

    private static ServiceRegistryClientEtcdImpl client;

    @BeforeClass
    public static void setup() {
        ServiceRegistryConnectionEtcdImpl connection = new ServiceRegistryConnectionEtcdImpl("etcd://127.0.0.1:2379");
        connection.connect();
        client = new ServiceRegistryClientEtcdImpl(connection);
    }

    @Test
    public void discover() throws Exception {
        List<ServiceInstance> instanceList = client.discover("Core", "UserService", Version.valueOf("1.0.0"));
        for(ServiceInstance instance : instanceList) {
            System.out.println("instance=" + instance);
        }
    }

}
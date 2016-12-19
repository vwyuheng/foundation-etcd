package net.basiccloud.etcd.registry.internal.entity;

import net.basiccloud.registry.ServiceInstance;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class KeyUtilTest {

    @Test
    public void instanceDataKey() {
        String instanceDataKey = KeyUtil.instanceDataKey("Core", "UserService", "192.168.0.1", 1080);
        //System.out.println("instanceDataKey=" + instanceDataKey);
        assertThat(instanceDataKey).isEqualTo("/registry/Core/UserService/192.168.0.1:1080/data");
    }

    @Test
    public void instanceStatusKey() {
        String instanceStatusKey = KeyUtil.instanceStatusKey("Core", "UserService", "192.168.0.1", 1080);
        //System.out.println("instanceStatusKey=" + instanceStatusKey);
        assertThat(instanceStatusKey).isEqualTo("/registry/Core/UserService/192.168.0.1:1080/status");
    }

    @Test
    public void instanceDiscoverKey() {
        String beginKey = KeyUtil.instanceDiscoverBeginKey("Core", "UserService");
        //System.out.println("beginKey=" + beginKey);
        assertThat(beginKey).isEqualTo("/registry/Core/UserService/");
        String endKey = KeyUtil.instanceDiscoverEndKey("Core", "UserService");
        //System.out.println("endKey=" + endKey);
        assertThat(endKey).isEqualTo("/registry/Core/UserService/þ");
    }

    @Test
    public void parseInstanceDataKey() {
        Optional<ServiceInstance> serviceInstanceOptional = KeyUtil.parseInstanceDataKey(
                "/registry/Core/UserService/192.168.0.1:1080/data");
        assertThat(serviceInstanceOptional.isPresent()).isTrue();
        ServiceInstance instance = serviceInstanceOptional.get();
        //System.out.println("instance=" + instance);
        assertThat(instance.getGroup()).isEqualTo("Core");
        assertThat(instance.getService()).isEqualTo("UserService");
        assertThat(instance.getIp()).isEqualTo("192.168.0.1");
        assertThat(instance.getPort()).isEqualTo(1080);
        assertThat(instance.getData()).isNull();
        assertThat(instance.getStatus()).isNull();
    }

    @Test
    public void parseInstanceStatusKey() {
        Optional<ServiceInstance> serviceInstanceOptional = KeyUtil.parseInstanceStatusKey(
                "/registry/Core/UserService/192.168.0.1:1080/status");
        assertThat(serviceInstanceOptional.isPresent()).isTrue();
        ServiceInstance instance = serviceInstanceOptional.get();
        //System.out.println("instance=" + instance);
        assertThat(instance.getGroup()).isEqualTo("Core");
        assertThat(instance.getService()).isEqualTo("UserService");
        assertThat(instance.getIp()).isEqualTo("192.168.0.1");
        assertThat(instance.getPort()).isEqualTo(1080);
        assertThat(instance.getData()).isNull();
        assertThat(instance.getStatus()).isNull();
    }

    @Test
    public void testParseInstanceStatusKey() {
        String key = "/registry1/Core/UserService/192.168.0.1:1080/status";
        Optional<ServiceInstance> serviceInstance = KeyUtil.parseInstanceDataKey(key);
        assertThat(serviceInstance.isPresent()).isFalse();
    }

    @Test
    public void testParseInstanceStatusKey_separator_string_length_not_6() {
        String key = "/registry/Core/UserService/192.168.0.1:1080/status/data";
        Optional<ServiceInstance> serviceInstance = KeyUtil.parseInstanceDataKey(key);
        assertThat(serviceInstance.isPresent()).isFalse();
    }
}
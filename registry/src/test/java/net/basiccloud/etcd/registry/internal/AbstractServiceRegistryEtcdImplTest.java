package net.basiccloud.etcd.registry.internal;

import com.google.protobuf.ByteString;

import com.coreos.etcd3.api.KVGrpc;
import com.coreos.etcd3.api.LeaseGrantRequest;
import com.coreos.etcd3.api.LeaseGrantResponse;
import com.coreos.etcd3.api.LeaseGrpc;
import com.coreos.etcd3.api.LeaseRevokeRequest;
import com.coreos.etcd3.api.PutRequest;
import com.coreos.etcd3.api.RangeRequest;
import com.coreos.etcd3.api.RangeResponse;

import net.basiccloud.etcd.registry.internal.entity.KeyUtil;
import net.basiccloud.etcd.registry.internal.entity.ValueUtil;
import net.basiccloud.registry.ServiceInstance;
import net.basiccloud.registry.ServiceInstanceData;
import net.basiccloud.registry.ServiceInstanceStatus;
import net.basiccloud.registry.Version;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;
import java.util.Optional;

import mvccpb.Kv;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({KVGrpc.KVBlockingStub.class, LeaseGrpc.LeaseBlockingStub.class})
@PowerMockIgnore("javax.management.*")
public class AbstractServiceRegistryEtcdImplTest {

    @InjectMocks
    private AbstractServiceRegistryEtcdImpl serviceRegistryEtcd = new ServiceRegistryServerEtcdImpl();

    @Mock
    private KVGrpc.KVBlockingStub kvBlockingStub;

    @Mock
    private LeaseGrpc.LeaseBlockingStub leaseBlockingStub;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        reset(kvBlockingStub, leaseBlockingStub);
    }

    @Test
    public void instanceDataQuery_not_empty() throws Exception {
        String ip = "127.0.0.1";
        String group = "dolphin";
        String service = "registryService";
        int port = 81;
        final String instanceDataKey = KeyUtil.instanceDataKey(group, service, ip, port);

        RangeRequest rangeRequest = RangeRequest.newBuilder().setKey(ByteString.copyFromUtf8(instanceDataKey)).build();
        ServiceInstanceData serviceInstanceData = ServiceInstanceData.newBuilder()
                .setServiceVersion("0.1.1")
                .setFrameworkVersion(Version.valueOf("0.1.0"))
                .build();
        Kv.KeyValue keyValue = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(instanceDataKey))
                .setValue(ByteString.copyFromUtf8(ValueUtil.toJson(serviceInstanceData)))
                .build();

        when(kvBlockingStub.range(rangeRequest)).thenReturn(
                RangeResponse.newBuilder().addKvs(keyValue).setCount(1).build());
        ServiceInstance serviceInstance =
                ServiceInstance.newBuilder().setIp(ip).setGroup(group).setPort(port).setService(service).build();

        Optional<ServiceInstanceData> result = serviceRegistryEtcd.instanceDataQuery(serviceInstance);
        assertThat(result.isPresent()).isTrue();
        verify(kvBlockingStub).range(rangeRequest);
    }

    @Test
    public void instanceDataQuery_is_empty() throws Exception {
        String ip = "127.0.0.1";
        String group = "dolphin";
        String service = "registryService";
        int port = 81;
        final String instanceDataKey = KeyUtil.instanceDataKey(group, service, ip, port);

        RangeRequest rangeRequest = RangeRequest.newBuilder().setKey(ByteString.copyFromUtf8(instanceDataKey)).build();
        ServiceInstanceData serviceInstanceData = ServiceInstanceData.newBuilder()
                .setServiceVersion("0.1.1")
                .setFrameworkVersion(Version.valueOf("0.1.0"))
                .build();
        Kv.KeyValue keyValue = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(instanceDataKey))
                .setValue(ByteString.copyFromUtf8(ValueUtil.toJson(serviceInstanceData)))
                .build();

        when(kvBlockingStub.range(rangeRequest)).thenReturn(RangeResponse.newBuilder().addKvs(keyValue).build());
        ServiceInstance serviceInstance =
                ServiceInstance.newBuilder().setIp(ip).setGroup(group).setPort(port).setService(service).build();

        Optional<ServiceInstanceData> result = serviceRegistryEtcd.instanceDataQuery(serviceInstance);
        assertThat(result.isPresent()).isFalse();
        verify(kvBlockingStub).range(rangeRequest);
    }

    @Test
    public void instanceDataSave() throws Exception {
        String ip = "127.0.0.1";
        String group = "dolphin";
        String service = "registryService";
        int port = 81;

        ServiceInstanceData serviceInstanceData = ServiceInstanceData.newBuilder()
                .setServiceVersion(Version.valueOf("0.0.1"))
                .setFrameworkVersion("0.00.0")
                .build();
        ServiceInstance serviceInstance = ServiceInstance.newBuilder()
                .setData(serviceInstanceData)
                .setService(service)
                .setPort(port)
                .setGroup(group)
                .setIp(ip)
                .build();
        serviceRegistryEtcd.instanceDataSave(serviceInstance);

        verify(kvBlockingStub).put(anyObject());
    }

    @Test
    public void instanceStatusQuery_not_empty() throws Exception {
        String ip = "127.0.0.1";
        String group = "dolphin";
        String service = "registryService";
        int port = 81;

        final String instanceDataKey = KeyUtil.instanceStatusKey(group, service, ip, port);

        ServiceInstance serviceInstance =
                ServiceInstance.newBuilder().setIp(ip).setPort(port).setService(service).setGroup(group).build();
        ServiceInstanceStatus status = ServiceInstanceStatus.newBuilder()
                .setStatus(ServiceInstanceStatus.Status.OFFLINE)
                .setLastUpdateTime(System.currentTimeMillis())
                .setComment("")
                .build();
        Kv.KeyValue keyValue = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(instanceDataKey))
                .setValue(ByteString.copyFromUtf8(ValueUtil.toJson(status)))
                .build();
        RangeRequest rangeRequest = RangeRequest.newBuilder().setKey(ByteString.copyFromUtf8(instanceDataKey)).build();

        when(kvBlockingStub.range(rangeRequest)).thenReturn(
                RangeResponse.newBuilder().addKvs(keyValue).setCount(1).build());
        Optional<ServiceInstanceStatus> serviceInstanceStatus =
                serviceRegistryEtcd.instanceStatusQuery(serviceInstance);

        assertThat(serviceInstanceStatus.isPresent()).isTrue();
        verify(kvBlockingStub).range(rangeRequest);
    }

    @Test
    public void instanceStatusQuery_is_empty() throws Exception {
        String ip = "127.0.0.1";
        String group = "dolphin";
        String service = "registryService";
        int port = 81;

        final String instanceDataKey = KeyUtil.instanceStatusKey(group, service, ip, port);

        ServiceInstance serviceInstance =
                ServiceInstance.newBuilder().setIp(ip).setPort(port).setService(service).setGroup(group).build();
        ServiceInstanceStatus status = ServiceInstanceStatus.newBuilder()
                .setStatus(ServiceInstanceStatus.Status.OFFLINE)
                .setLastUpdateTime(System.currentTimeMillis())
                .setComment("")
                .build();
        Kv.KeyValue keyValue = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(instanceDataKey))
                .setValue(ByteString.copyFromUtf8(ValueUtil.toJson(status)))
                .build();
        RangeRequest rangeRequest = RangeRequest.newBuilder().setKey(ByteString.copyFromUtf8(instanceDataKey)).build();

        when(kvBlockingStub.range(rangeRequest)).thenReturn(RangeResponse.newBuilder().addKvs(keyValue).build());
        Optional<ServiceInstanceStatus> serviceInstanceStatus =
                serviceRegistryEtcd.instanceStatusQuery(serviceInstance);

        assertThat(serviceInstanceStatus.isPresent()).isFalse();
        verify(kvBlockingStub).range(rangeRequest);
    }

    @Test
    public void instanceStatusSave() throws Exception {
        String ip = "127.0.0.1";
        String group = "dolphin";
        String service = "registryService";
        int port = 81;
        ServiceInstanceStatus status = ServiceInstanceStatus.newBuilder()
                .setComment("")
                .setLastUpdateTime(System.currentTimeMillis())
                .setStatus(ServiceInstanceStatus.Status.OFFLINE)
                .build();
        ServiceInstance serviceInstance = ServiceInstance.newBuilder()
                .setGroup(group)
                .setService(service)
                .setPort(port)
                .setIp(ip)
                .setStatus(status)
                .build();

        serviceRegistryEtcd.instanceStatusSave(serviceInstance);

        String instanceStatusKey = KeyUtil.instanceStatusKey(serviceInstance.getGroup(), serviceInstance.getService(),
                                                             serviceInstance.getIp(), serviceInstance.getPort());
        String instanceStatusValue = ValueUtil.toJson(serviceInstance.getStatus());
        PutRequest putRequest = PutRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(instanceStatusKey))
                .setValue(ByteString.copyFromUtf8(instanceStatusValue))
                .build();
        verify(kvBlockingStub).put(putRequest);
    }


    @Test
    public void instanceStatusSave1() throws Exception {
        String ip = "127.0.0.1";
        String group = "dolphin";
        String service = "registryService";
        int port = 81;
        ServiceInstanceStatus status = ServiceInstanceStatus.newBuilder()
                .setComment("")
                .setLastUpdateTime(System.currentTimeMillis())
                .setStatus(ServiceInstanceStatus.Status.OFFLINE)
                .build();
        ServiceInstance serviceInstance = ServiceInstance.newBuilder()
                .setGroup(group)
                .setService(service)
                .setPort(port)
                .setIp(ip)
                .setStatus(status)
                .build();

        serviceRegistryEtcd.instanceStatusSave(serviceInstance, 1);

        String instanceStatusKey = KeyUtil.instanceStatusKey(serviceInstance.getGroup(), serviceInstance.getService(),
                                                             serviceInstance.getIp(), serviceInstance.getPort());
        String instanceStatusValue = ValueUtil.toJson(serviceInstance.getStatus());
        PutRequest putRequest = PutRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(instanceStatusKey))
                .setValue(ByteString.copyFromUtf8(instanceStatusValue))
                .setLease(1)
                .build();
        verify(kvBlockingStub).put(putRequest);
    }

    @Test
    public void instanceQuery_only_data() throws Exception {
        String group = "dolphin";
        String service = "registryService";
        String ip = "127.0.0.1";
        int port = 88;
        Version version = Version.valueOf("0.1.0");
        String beginKey = KeyUtil.instanceDiscoverBeginKey(group, service);
        String endKey = KeyUtil.instanceDiscoverEndKey(group, service);
        RangeRequest rangeRequest = RangeRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(beginKey))
                .setRangeEnd(ByteString.copyFromUtf8(endKey))
                .setSortTarget(RangeRequest.SortTarget.KEY)
                .build();
        String dataKey = KeyUtil.instanceDataKey(group, service, ip, port);
        String dataKey2 = KeyUtil.instanceDataKey(group, service + "2", ip, port);
        ServiceInstanceData serviceInstanceData = ServiceInstanceData.newBuilder()
                .setServiceVersion(version)
                .setServiceType("dolphin")
                .setFrameworkVersion(Version.valueOf("1.2.3"))
                .build();
        ServiceInstanceData serviceInstanceData2 = ServiceInstanceData.newBuilder()
                .setServiceVersion("0.2.0")
                .setServiceType("dolphin")
                .setFrameworkVersion(Version.valueOf("1.2.3"))
                .build();
        String dataValue = ValueUtil.toJson(serviceInstanceData);
        String dataValue2 = ValueUtil.toJson(serviceInstanceData2);
        Kv.KeyValue keyValue = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(dataKey))
                .setValue(ByteString.copyFromUtf8(dataValue))
                .build();
        Kv.KeyValue keyValue2 = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(dataKey2))
                .setValue(ByteString.copyFromUtf8(dataValue2))
                .build();
        RangeResponse rangeResponse = RangeResponse.newBuilder().addKvs(keyValue).addKvs(keyValue2).build();
        when(kvBlockingStub.range(rangeRequest)).thenReturn(rangeResponse);

        List<ServiceInstance> serviceInstances = serviceRegistryEtcd.instanceQuery(group, service, version);

        assertThat(serviceInstances.isEmpty()).isTrue();
        verify(kvBlockingStub).range(rangeRequest);
    }


    @Test
    public void instanceQuery_only_status() throws Exception {
        String group = "dolphin";
        String service = "registryService";
        String ip = "127.0.0.1";
        int port = 88;
        //data preparation
        Version version = Version.valueOf("0.1.0");
        String beginKey = KeyUtil.instanceDiscoverBeginKey(group, service);
        String endKey = KeyUtil.instanceDiscoverEndKey(group, service);
        String statusKey = KeyUtil.instanceStatusKey(group, service, ip, port);
        String statusKey2 = KeyUtil.instanceStatusKey(group, service + "2", ip, port);
        ServiceInstanceStatus instanceStatus = ServiceInstanceStatus.newBuilder()
                .setComment("")
                .setLastUpdateTime(System.currentTimeMillis())
                .setStatus(ServiceInstanceStatus.Status.ONLINE)
                .build();
        ServiceInstanceStatus instanceStatus2 = ServiceInstanceStatus.newBuilder()
                .setComment("")
                .setLastUpdateTime(System.currentTimeMillis())
                .setStatus(ServiceInstanceStatus.Status.OFFLINE)
                .build();
        String statusValue = ValueUtil.toJson(instanceStatus);
        String statusValue2 = ValueUtil.toJson(instanceStatus2);
        Kv.KeyValue keyValue = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(statusKey))
                .setValue(ByteString.copyFromUtf8(statusValue))
                .build();
        Kv.KeyValue keyValue2 = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(statusKey2))
                .setValue(ByteString.copyFromUtf8(statusValue2))
                .build();
        //mock
        RangeRequest rangeRequest = RangeRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(beginKey))
                .setRangeEnd(ByteString.copyFromUtf8(endKey))
                .setSortTarget(RangeRequest.SortTarget.KEY)
                .build();
        RangeResponse rangeResponse = RangeResponse.newBuilder().addKvs(keyValue).addKvs(keyValue2).build();
        when(kvBlockingStub.range(rangeRequest)).thenReturn(rangeResponse);

        List<ServiceInstance> serviceInstances = serviceRegistryEtcd.instanceQuery(group, service, version);

        assertThat(serviceInstances.isEmpty()).isTrue();
        verify(kvBlockingStub).range(rangeRequest);
    }


    @Test
    public void instanceQuery_one_online() throws Exception {
        String group = "dolphin";
        String service = "registryService";
        String ip = "127.0.0.1";
        int port = 88;
        //data preparation
        Version version = Version.valueOf("0.1.0");
        String beginKey = KeyUtil.instanceDiscoverBeginKey(group, service);
        String endKey = KeyUtil.instanceDiscoverEndKey(group, service);

        //status
        String statusKey = KeyUtil.instanceStatusKey(group, service, ip, port);
        String statusKey2 = KeyUtil.instanceStatusKey(group, service + "2", ip, port);

        ServiceInstanceStatus instanceStatus = ServiceInstanceStatus.newBuilder()
                .setComment("")
                .setLastUpdateTime(System.currentTimeMillis())
                .setStatus(ServiceInstanceStatus.Status.ONLINE)
                .build();
        ServiceInstanceStatus instanceStatus2 = ServiceInstanceStatus.newBuilder()
                .setComment("")
                .setLastUpdateTime(System.currentTimeMillis())
                .setStatus(ServiceInstanceStatus.Status.OFFLINE)
                .build();
        String statusValue = ValueUtil.toJson(instanceStatus);
        String statusValue2 = ValueUtil.toJson(instanceStatus2);
        Kv.KeyValue statusKeyValue = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(statusKey))
                .setValue(ByteString.copyFromUtf8(statusValue))
                .build();
        Kv.KeyValue statusKeyValue2 = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(statusKey2))
                .setValue(ByteString.copyFromUtf8(statusValue2))
                .build();
        //data
        String dataKey = KeyUtil.instanceDataKey(group, service, ip, port);
        String dataKey2 = KeyUtil.instanceDataKey(group, service + "2", ip, port);
        ServiceInstanceData serviceInstanceData = ServiceInstanceData.newBuilder()
                .setFrameworkVersion("1.1.1")
                .setServiceType("registry")
                .setServiceVersion(Version.valueOf("0.2.0"))
                .build();
        ServiceInstanceData serviceInstanceData2 = ServiceInstanceData.newBuilder()
                .setFrameworkVersion("1.1.1")
                .setServiceType("registry")
                .setServiceVersion(Version.valueOf("0.2.0"))
                .build();
        String dataValue = ValueUtil.toJson(serviceInstanceData);
        String dataValue2 = ValueUtil.toJson(serviceInstanceData2);
        Kv.KeyValue dataKeyValue = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(dataKey))
                .setValue(ByteString.copyFromUtf8(dataValue))
                .build();
        Kv.KeyValue dataKeyValue2 = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(dataKey2))
                .setValue(ByteString.copyFromUtf8(dataValue2))
                .build();
        RangeResponse rangeResponse = RangeResponse.newBuilder()
                .addKvs(statusKeyValue)
                .addKvs(statusKeyValue2)
                .addKvs(dataKeyValue)
                .addKvs(dataKeyValue2)
                .build();
        //mock
        RangeRequest rangeRequest = RangeRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(beginKey))
                .setRangeEnd(ByteString.copyFromUtf8(endKey))
                .setSortTarget(RangeRequest.SortTarget.KEY)
                .build();
        when(kvBlockingStub.range(rangeRequest)).thenReturn(rangeResponse);

        List<ServiceInstance> serviceInstances = serviceRegistryEtcd.instanceQuery(group, service, version);

        assertThat(serviceInstances.size()).isEqualTo(1);
        verify(kvBlockingStub).range(rangeRequest);
    }


    @Test
    public void instanceQuery_two_online() throws Exception {
        String group = "dolphin";
        String service = "registryService";
        String ip = "127.0.0.1";
        int port = 88;
        //data preparation
        Version version = Version.valueOf("0.1.0");
        String beginKey = KeyUtil.instanceDiscoverBeginKey(group, service);
        String endKey = KeyUtil.instanceDiscoverEndKey(group, service);

        //status
        String statusKey = KeyUtil.instanceStatusKey(group, service, ip, port);
        String statusKey2 = KeyUtil.instanceStatusKey(group, service + "2", ip, port);

        ServiceInstanceStatus instanceStatus = ServiceInstanceStatus.newBuilder()
                .setComment("")
                .setLastUpdateTime(System.currentTimeMillis())
                .setStatus(ServiceInstanceStatus.Status.ONLINE)
                .build();
        ServiceInstanceStatus instanceStatus2 = ServiceInstanceStatus.newBuilder()
                .setComment("")
                .setLastUpdateTime(System.currentTimeMillis())
                .setStatus(ServiceInstanceStatus.Status.ONLINE)
                .build();
        String statusValue = ValueUtil.toJson(instanceStatus);
        String statusValue2 = ValueUtil.toJson(instanceStatus2);
        Kv.KeyValue statusKeyValue = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(statusKey))
                .setValue(ByteString.copyFromUtf8(statusValue))
                .build();
        Kv.KeyValue statusKeyValue2 = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(statusKey2))
                .setValue(ByteString.copyFromUtf8(statusValue2))
                .build();
        //data
        String dataKey = KeyUtil.instanceDataKey(group, service, ip, port);
        String dataKey2 = KeyUtil.instanceDataKey(group, service + "2", ip, port);
        ServiceInstanceData serviceInstanceData = ServiceInstanceData.newBuilder()
                .setFrameworkVersion("1.1.1")
                .setServiceType("registry")
                .setServiceVersion(Version.valueOf("0.2.0"))
                .build();
        ServiceInstanceData serviceInstanceData2 = ServiceInstanceData.newBuilder()
                .setFrameworkVersion("1.1.1")
                .setServiceType("registry")
                .setServiceVersion(Version.valueOf("0.2.0"))
                .build();
        String dataValue = ValueUtil.toJson(serviceInstanceData);
        String dataValue2 = ValueUtil.toJson(serviceInstanceData2);
        Kv.KeyValue dataKeyValue = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(dataKey))
                .setValue(ByteString.copyFromUtf8(dataValue))
                .build();
        Kv.KeyValue dataKeyValue2 = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(dataKey2))
                .setValue(ByteString.copyFromUtf8(dataValue2))
                .build();
        RangeResponse rangeResponse = RangeResponse.newBuilder()
                .addKvs(statusKeyValue)
                .addKvs(statusKeyValue2)
                .addKvs(dataKeyValue)
                .addKvs(dataKeyValue2)
                .build();
        //mock
        RangeRequest rangeRequest = RangeRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(beginKey))
                .setRangeEnd(ByteString.copyFromUtf8(endKey))
                .setSortTarget(RangeRequest.SortTarget.KEY)
                .build();
        when(kvBlockingStub.range(rangeRequest)).thenReturn(rangeResponse);

        List<ServiceInstance> serviceInstances = serviceRegistryEtcd.instanceQuery(group, service, version);

        assertThat(serviceInstances.size()).isEqualTo(2);
        verify(kvBlockingStub).range(rangeRequest);
    }


    @Test
    public void instanceQuery_none_online() throws Exception {
        String group = "dolphin";
        String service = "registryService";
        String ip = "127.0.0.1";
        int port = 88;
        //data preparation
        Version version = Version.valueOf("0.1.0");
        String beginKey = KeyUtil.instanceDiscoverBeginKey(group, service);
        String endKey = KeyUtil.instanceDiscoverEndKey(group, service);

        //status
        String statusKey = KeyUtil.instanceStatusKey(group, service, ip, port);
        String statusKey2 = KeyUtil.instanceStatusKey(group, service + "2", ip, port);

        ServiceInstanceStatus instanceStatus = ServiceInstanceStatus.newBuilder()
                .setComment("")
                .setLastUpdateTime(System.currentTimeMillis())
                .setStatus(ServiceInstanceStatus.Status.OFFLINE)
                .build();
        ServiceInstanceStatus instanceStatus2 = ServiceInstanceStatus.newBuilder()
                .setComment("")
                .setLastUpdateTime(System.currentTimeMillis())
                .setStatus(ServiceInstanceStatus.Status.OFFLINE)
                .build();
        String statusValue = ValueUtil.toJson(instanceStatus);
        String statusValue2 = ValueUtil.toJson(instanceStatus2);
        Kv.KeyValue statusKeyValue = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(statusKey))
                .setValue(ByteString.copyFromUtf8(statusValue))
                .build();
        Kv.KeyValue statusKeyValue2 = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(statusKey2))
                .setValue(ByteString.copyFromUtf8(statusValue2))
                .build();
        //data
        String dataKey = KeyUtil.instanceDataKey(group, service, ip, port);
        String dataKey2 = KeyUtil.instanceDataKey(group, service + "2", ip, port);
        ServiceInstanceData serviceInstanceData = ServiceInstanceData.newBuilder()
                .setFrameworkVersion("1.1.1")
                .setServiceType("registry")
                .setServiceVersion(Version.valueOf("0.2.0"))
                .build();
        ServiceInstanceData serviceInstanceData2 = ServiceInstanceData.newBuilder()
                .setFrameworkVersion("1.1.1")
                .setServiceType("registry")
                .setServiceVersion(Version.valueOf("0.2.0"))
                .build();
        String dataValue = ValueUtil.toJson(serviceInstanceData);
        String dataValue2 = ValueUtil.toJson(serviceInstanceData2);
        Kv.KeyValue dataKeyValue = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(dataKey))
                .setValue(ByteString.copyFromUtf8(dataValue))
                .build();
        Kv.KeyValue dataKeyValue2 = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(dataKey2))
                .setValue(ByteString.copyFromUtf8(dataValue2))
                .build();
        RangeResponse rangeResponse = RangeResponse.newBuilder()
                .addKvs(statusKeyValue)
                .addKvs(statusKeyValue2)
                .addKvs(dataKeyValue)
                .addKvs(dataKeyValue2)
                .build();
        //mock
        RangeRequest rangeRequest = RangeRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(beginKey))
                .setRangeEnd(ByteString.copyFromUtf8(endKey))
                .setSortTarget(RangeRequest.SortTarget.KEY)
                .build();
        when(kvBlockingStub.range(rangeRequest)).thenReturn(rangeResponse);

        List<ServiceInstance> serviceInstances = serviceRegistryEtcd.instanceQuery(group, service, version);

        assertThat(serviceInstances.size()).isEqualTo(0);
        verify(kvBlockingStub).range(rangeRequest);
    }


    @Test
    public void instanceQuery_two_version() throws Exception {
        String group = "dolphin";
        String service = "registryService";
        String ip = "127.0.0.1";
        int port = 88;
        //data preparation
        Version version = Version.valueOf("0.1.0");
        String beginKey = KeyUtil.instanceDiscoverBeginKey(group, service);
        String endKey = KeyUtil.instanceDiscoverEndKey(group, service);

        //status
        String statusKey = KeyUtil.instanceStatusKey(group, service, ip, port);
        String statusKey2 = KeyUtil.instanceStatusKey(group, service + "2", ip, port);

        ServiceInstanceStatus instanceStatus = ServiceInstanceStatus.newBuilder()
                .setComment("")
                .setLastUpdateTime(System.currentTimeMillis())
                .setStatus(ServiceInstanceStatus.Status.ONLINE)
                .build();
        ServiceInstanceStatus instanceStatus2 = ServiceInstanceStatus.newBuilder()
                .setComment("")
                .setLastUpdateTime(System.currentTimeMillis())
                .setStatus(ServiceInstanceStatus.Status.ONLINE)
                .build();
        String statusValue = ValueUtil.toJson(instanceStatus);
        String statusValue2 = ValueUtil.toJson(instanceStatus2);
        Kv.KeyValue statusKeyValue = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(statusKey))
                .setValue(ByteString.copyFromUtf8(statusValue))
                .build();
        Kv.KeyValue statusKeyValue2 = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(statusKey2))
                .setValue(ByteString.copyFromUtf8(statusValue2))
                .build();
        //data
        String dataKey = KeyUtil.instanceDataKey(group, service, ip, port);
        String dataKey2 = KeyUtil.instanceDataKey(group, service + "2", ip, port);
        ServiceInstanceData serviceInstanceData = ServiceInstanceData.newBuilder()
                .setFrameworkVersion("1.1.1")
                .setServiceType("registry")
                .setServiceVersion(Version.valueOf("0.2.0"))
                .build();
        ServiceInstanceData serviceInstanceData2 = ServiceInstanceData.newBuilder()
                .setFrameworkVersion("1.1.1")
                .setServiceType("registry")
                .setServiceVersion(Version.valueOf("0.2.1"))
                .build();
        String dataValue = ValueUtil.toJson(serviceInstanceData);
        String dataValue2 = ValueUtil.toJson(serviceInstanceData2);
        Kv.KeyValue dataKeyValue = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(dataKey))
                .setValue(ByteString.copyFromUtf8(dataValue))
                .build();
        Kv.KeyValue dataKeyValue2 = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(dataKey2))
                .setValue(ByteString.copyFromUtf8(dataValue2))
                .build();
        RangeResponse rangeResponse = RangeResponse.newBuilder()
                .addKvs(statusKeyValue)
                .addKvs(statusKeyValue2)
                .addKvs(dataKeyValue)
                .addKvs(dataKeyValue2)
                .build();
        //mock
        RangeRequest rangeRequest = RangeRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(beginKey))
                .setRangeEnd(ByteString.copyFromUtf8(endKey))
                .setSortTarget(RangeRequest.SortTarget.KEY)
                .build();
        when(kvBlockingStub.range(rangeRequest)).thenReturn(rangeResponse);

        List<ServiceInstance> serviceInstances = serviceRegistryEtcd.instanceQuery(group, service, version);

        assertThat(serviceInstances.size()).isEqualTo(2);
        verify(kvBlockingStub).range(rangeRequest);
    }


    @Test
    public void instanceQuery_one_version() throws Exception {
        String group = "dolphin";
        String service = "registryService";
        String ip = "127.0.0.1";
        int port = 88;
        //data preparation
        Version version = Version.valueOf("0.1.0");
        String beginKey = KeyUtil.instanceDiscoverBeginKey(group, service);
        String endKey = KeyUtil.instanceDiscoverEndKey(group, service);

        //status
        String statusKey = KeyUtil.instanceStatusKey(group, service, ip, port);
        String statusKey2 = KeyUtil.instanceStatusKey(group, service + "2", ip, port);

        ServiceInstanceStatus instanceStatus = ServiceInstanceStatus.newBuilder()
                .setComment("")
                .setLastUpdateTime(System.currentTimeMillis())
                .setStatus(ServiceInstanceStatus.Status.ONLINE)
                .build();
        ServiceInstanceStatus instanceStatus2 = ServiceInstanceStatus.newBuilder()
                .setComment("")
                .setLastUpdateTime(System.currentTimeMillis())
                .setStatus(ServiceInstanceStatus.Status.ONLINE)
                .build();
        String statusValue = ValueUtil.toJson(instanceStatus);
        String statusValue2 = ValueUtil.toJson(instanceStatus2);
        Kv.KeyValue statusKeyValue = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(statusKey))
                .setValue(ByteString.copyFromUtf8(statusValue))
                .build();
        Kv.KeyValue statusKeyValue2 = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(statusKey2))
                .setValue(ByteString.copyFromUtf8(statusValue2))
                .build();
        //data
        String dataKey = KeyUtil.instanceDataKey(group, service, ip, port);
        String dataKey2 = KeyUtil.instanceDataKey(group, service + "2", ip, port);
        ServiceInstanceData serviceInstanceData = ServiceInstanceData.newBuilder()
                .setFrameworkVersion("1.1.1")
                .setServiceType("registry")
                .setServiceVersion(Version.valueOf("0.2.0"))
                .build();
        ServiceInstanceData serviceInstanceData2 = ServiceInstanceData.newBuilder()
                .setFrameworkVersion("1.1.1")
                .setServiceType("registry")
                .setServiceVersion(Version.valueOf("1.2.0"))
                .build();
        String dataValue = ValueUtil.toJson(serviceInstanceData);
        String dataValue2 = ValueUtil.toJson(serviceInstanceData2);
        Kv.KeyValue dataKeyValue = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(dataKey))
                .setValue(ByteString.copyFromUtf8(dataValue))
                .build();
        Kv.KeyValue dataKeyValue2 = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(dataKey2))
                .setValue(ByteString.copyFromUtf8(dataValue2))
                .build();
        RangeResponse rangeResponse = RangeResponse.newBuilder()
                .addKvs(statusKeyValue)
                .addKvs(statusKeyValue2)
                .addKvs(dataKeyValue)
                .addKvs(dataKeyValue2)
                .build();
        //mock
        RangeRequest rangeRequest = RangeRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(beginKey))
                .setRangeEnd(ByteString.copyFromUtf8(endKey))
                .setSortTarget(RangeRequest.SortTarget.KEY)
                .build();
        when(kvBlockingStub.range(rangeRequest)).thenReturn(rangeResponse);

        List<ServiceInstance> serviceInstances = serviceRegistryEtcd.instanceQuery(group, service, version);

        assertThat(serviceInstances.size()).isEqualTo(1);
        verify(kvBlockingStub).range(rangeRequest);
    }

    @Test
    public void instanceQuery_none_version() throws Exception {
        String group = "dolphin";
        String service = "registryService";
        String ip = "127.0.0.1";
        int port = 88;
        //data preparation
        Version version = Version.valueOf("0.1.0");
        String beginKey = KeyUtil.instanceDiscoverBeginKey(group, service);
        String endKey = KeyUtil.instanceDiscoverEndKey(group, service);

        //status
        String statusKey = KeyUtil.instanceStatusKey(group, service, ip, port);
        String statusKey2 = KeyUtil.instanceStatusKey(group, service + "2", ip, port);

        ServiceInstanceStatus instanceStatus = ServiceInstanceStatus.newBuilder()
                .setComment("")
                .setLastUpdateTime(System.currentTimeMillis())
                .setStatus(ServiceInstanceStatus.Status.ONLINE)
                .build();
        ServiceInstanceStatus instanceStatus2 = ServiceInstanceStatus.newBuilder()
                .setComment("")
                .setLastUpdateTime(System.currentTimeMillis())
                .setStatus(ServiceInstanceStatus.Status.ONLINE)
                .build();
        String statusValue = ValueUtil.toJson(instanceStatus);
        String statusValue2 = ValueUtil.toJson(instanceStatus2);
        Kv.KeyValue statusKeyValue = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(statusKey))
                .setValue(ByteString.copyFromUtf8(statusValue))
                .build();
        Kv.KeyValue statusKeyValue2 = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(statusKey2))
                .setValue(ByteString.copyFromUtf8(statusValue2))
                .build();
        //data
        String dataKey = KeyUtil.instanceDataKey(group, service, ip, port);
        String dataKey2 = KeyUtil.instanceDataKey(group, service + "2", ip, port);
        ServiceInstanceData serviceInstanceData = ServiceInstanceData.newBuilder()
                .setFrameworkVersion("1.1.1")
                .setServiceType("registry")
                .setServiceVersion(Version.valueOf("2.2.0"))
                .build();
        ServiceInstanceData serviceInstanceData2 = ServiceInstanceData.newBuilder()
                .setFrameworkVersion("1.1.1")
                .setServiceType("registry")
                .setServiceVersion(Version.valueOf("1.2.0"))
                .build();
        String dataValue = ValueUtil.toJson(serviceInstanceData);
        String dataValue2 = ValueUtil.toJson(serviceInstanceData2);
        Kv.KeyValue dataKeyValue = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(dataKey))
                .setValue(ByteString.copyFromUtf8(dataValue))
                .build();
        Kv.KeyValue dataKeyValue2 = Kv.KeyValue.newBuilder()
                .setKey(ByteString.copyFromUtf8(dataKey2))
                .setValue(ByteString.copyFromUtf8(dataValue2))
                .build();
        RangeResponse rangeResponse = RangeResponse.newBuilder()
                .addKvs(statusKeyValue)
                .addKvs(statusKeyValue2)
                .addKvs(dataKeyValue)
                .addKvs(dataKeyValue2)
                .build();
        //mock
        RangeRequest rangeRequest = RangeRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(beginKey))
                .setRangeEnd(ByteString.copyFromUtf8(endKey))
                .setSortTarget(RangeRequest.SortTarget.KEY)
                .build();
        when(kvBlockingStub.range(rangeRequest)).thenReturn(rangeResponse);

        List<ServiceInstance> serviceInstances = serviceRegistryEtcd.instanceQuery(group, service, version);

        assertThat(serviceInstances.size()).isEqualTo(0);
        verify(kvBlockingStub).range(rangeRequest);
    }

    @Test
    public void instanceQuery_empty_value() throws Exception {
        String group = "dolphin";
        String service = "registryService";
        //data preparation
        Version version = Version.valueOf("0.1.0");
        String beginKey = KeyUtil.instanceDiscoverBeginKey(group, service);
        String endKey = KeyUtil.instanceDiscoverEndKey(group, service);
        RangeResponse rangeResponse = RangeResponse.newBuilder().build();
        //mock
        RangeRequest rangeRequest = RangeRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(beginKey))
                .setRangeEnd(ByteString.copyFromUtf8(endKey))
                .setSortTarget(RangeRequest.SortTarget.KEY)
                .build();
        when(kvBlockingStub.range(rangeRequest)).thenReturn(rangeResponse);

        List<ServiceInstance> serviceInstances = serviceRegistryEtcd.instanceQuery(group, service, version);

        assertThat(serviceInstances.size()).isEqualTo(0);
        verify(kvBlockingStub).range(rangeRequest);
    }

    @Test
    public void leaseGrant() throws Exception {
        int leaseTtlInSeconds = 2;
        int leaseId = 123;
        LeaseGrantRequest leaseGrantRequest = LeaseGrantRequest.newBuilder().setTTL(leaseTtlInSeconds).build();
        LeaseGrantResponse leaseGrantResponse =
                LeaseGrantResponse.newBuilder().setTTL(leaseTtlInSeconds).setID(leaseId).build();
        when(leaseBlockingStub.leaseGrant(leaseGrantRequest)).thenReturn(leaseGrantResponse);

        long l = serviceRegistryEtcd.leaseGrant(leaseTtlInSeconds);

        assertThat(l).isEqualTo(leaseId);
        verify(leaseBlockingStub).leaseGrant(leaseGrantRequest);
    }

    @Test
    public void leaseRevoke() throws Exception {
        long leaseId = 3L;
        serviceRegistryEtcd.leaseRevoke(leaseId);
        LeaseRevokeRequest leaseRevokeRequest = LeaseRevokeRequest.newBuilder().setID(leaseId).build();
        verify(leaseBlockingStub).leaseRevoke(leaseRevokeRequest);
    }

    @Test
    public void leaseRevoke_leaseId_less_zero() throws Exception {
        long leaseId = -1L;
        serviceRegistryEtcd.leaseRevoke(leaseId);
        LeaseRevokeRequest leaseRevokeRequest = LeaseRevokeRequest.newBuilder().setID(leaseId).build();
        verify(leaseBlockingStub, never()).leaseRevoke(leaseRevokeRequest);
    }
}
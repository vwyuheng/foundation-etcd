package net.basiccloud.etcd.registry.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
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
import net.basiccloud.registry.ServiceRegistryConnection;
import net.basiccloud.registry.Version;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import io.grpc.ManagedChannel;
import mvccpb.Kv;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

/**
 * Etcd abstract implementation of ServiceRegistry.
 */
abstract class AbstractServiceRegistryEtcdImpl {

    private static Logger logger = LoggerFactory.getLogger(AbstractServiceRegistryEtcdImpl.class);

    KVGrpc.KVBlockingStub kvBlockingStub;

    private LeaseGrpc.LeaseBlockingStub leaseBlockingStub;
    LeaseGrpc.LeaseStub leaseStub;

    @VisibleForTesting
    AbstractServiceRegistryEtcdImpl() {
    }

    AbstractServiceRegistryEtcdImpl(ServiceRegistryConnection connection) {
        ServiceRegistryConnectionEtcdImpl etcdConnection = (ServiceRegistryConnectionEtcdImpl) connection;
        ManagedChannel managedChannel = etcdConnection.getManagedChannel();
        this.kvBlockingStub = KVGrpc.newBlockingStub(managedChannel);
        this.leaseBlockingStub = LeaseGrpc.newBlockingStub(managedChannel);
        this.leaseStub = LeaseGrpc.newStub(managedChannel);
    }

    Optional<ServiceInstanceData> instanceDataQuery(ServiceInstance instance) {
        return instanceDataQuery(instance.getGroup(), instance.getService(), instance.getIp(), instance.getPort());
    }

    void instanceDataSave(ServiceInstance serviceInstance) {
        final String instanceDataKey = KeyUtil.instanceDataKey(serviceInstance.getGroup(), serviceInstance.getService(),
                                                               serviceInstance.getIp(), serviceInstance.getPort());
        final String instanceDataValue = ValueUtil.toJson(serviceInstance.getData());

        PutRequest.Builder builder = PutRequest.newBuilder().setKey(ByteString.copyFromUtf8(instanceDataKey)).setValue(
                ByteString.copyFromUtf8(instanceDataValue));
        PutRequest putRequest = builder.build();

        kvBlockingStub.put(putRequest);
        logger.info("success to save service instance data: key={}, value={}", instanceDataKey, instanceDataValue);
    }


    Optional<ServiceInstanceStatus> instanceStatusQuery(ServiceInstance instance) {
        return instanceStatusQuery(instance.getGroup(), instance.getService(), instance.getIp(), instance.getPort());
    }

    void instanceStatusSave(ServiceInstance serviceInstance) {
        instanceStatusSave(serviceInstance, 0);
    }

    void instanceStatusSave(ServiceInstance serviceInstance, long leaseId) {
        final String instanceStatusKey = instanceStatusKey(serviceInstance);
        final String instanceStatusValue = ValueUtil.toJson(serviceInstance.getStatus());

        PutRequest.Builder builder = PutRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(instanceStatusKey))
                .setValue(ByteString.copyFromUtf8(instanceStatusValue));
        if (leaseId > 0) {
            builder.setLease(leaseId);
        }
        PutRequest putRequest = builder.build();

        kvBlockingStub.put(putRequest);
        logger.info("success to save service instance status: leaseId={}, key={}, value={}", leaseId, instanceStatusKey,
                    instanceStatusValue);
    }

    List<ServiceInstance> instanceQuery(String group, String service, @Nullable Version version) {
        checkArgument(!Strings.isNullOrEmpty(group), "group should not be null or empty");
        checkArgument(!Strings.isNullOrEmpty(service), "service should not be null or empty");

        String beginKey = KeyUtil.instanceDiscoverBeginKey(group, service);
        String endKey = KeyUtil.instanceDiscoverEndKey(group, service);

        RangeRequest rangeRequest = RangeRequest.newBuilder().setKey(ByteString.copyFromUtf8(beginKey)).setRangeEnd(
                ByteString.copyFromUtf8(endKey)).setSortTarget(RangeRequest.SortTarget.KEY).build();
        RangeResponse rangeResponse = kvBlockingStub.range(rangeRequest);
        List<Kv.KeyValue> kvsList = rangeResponse.getKvsList();
        if (kvsList.isEmpty()) {
            logger.info("no service instance found: group={}, service={}", group, service);
            return new ArrayList<>();
        }

        Map<String, ServiceInstance> savedInstances = new HashMap<>();

        for (Kv.KeyValue kv : kvsList) {
            String key = kv.getKey().toStringUtf8();
            if (KeyUtil.isInstanceDataKey(key)) {
                mergeServiceInstanceWithData(savedInstances, key, kv.getValue().toStringUtf8());
            } else if (KeyUtil.isInstanceStatusKey(key)) {
                mergeServiceInstanceWithStatus(savedInstances, key, kv.getValue().toStringUtf8());
            }
        }
        //TODO need discuss and then add unit test
        if (version == null) {
            return savedInstances.values().stream().collect(Collectors.toList());
        }
        return filterServiceInstanceWithVersion(version, savedInstances);
    }

    private void mergeServiceInstanceWithData(Map<String, ServiceInstance> savedInstances, String key, String value) {
        Optional<ServiceInstance> instanceOptional = KeyUtil.parseInstanceDataKey(key);
        if (instanceOptional.isPresent()) {
            ServiceInstance instance = instanceOptional.get();
            ServiceInstanceData instanceData = ValueUtil.fromDataJson(value);

            ServiceInstance savedInstance = savedInstances.get(instance.getId());
            if (savedInstance == null) {
                savedInstance = instance;
            }
            savedInstances.put(instance.getId(), ServiceInstance.newBuilder(savedInstance)
                    .setData(instanceData)
                    .build());
        }
    }

    private void mergeServiceInstanceWithStatus(Map<String, ServiceInstance> savedInstances, String key, String value) {
        Optional<ServiceInstance> instanceOptional = KeyUtil.parseInstanceStatusKey(key);
        if (instanceOptional.isPresent()) {
            ServiceInstance instance = instanceOptional.get();
            ServiceInstanceStatus serviceInstanceStatus = ValueUtil.fromStatusJson(value);

            ServiceInstance savedInstance = savedInstances.get(instance.getId());
            if (savedInstance == null) {
                savedInstance = instance;
            }
            savedInstances.put(instance.getId(), ServiceInstance.newBuilder(savedInstance)
                    .setStatus(serviceInstanceStatus)
                    .build());
        }
    }

    private List<ServiceInstance> filterServiceInstanceWithVersion(Version version,
            Map<String, ServiceInstance> savedInstances) {
        return savedInstances.values()
                .stream()
                .filter(serviceInstance -> serviceInstance.getData() != null && serviceInstance.getStatus() != null && serviceInstance
                        .getStatus()
                        .isOnline() && serviceInstance.getData().getServiceVersion().isBackCompatibleWith(version))
                .collect(Collectors.toList());
    }

    long leaseGrant(long leaseTtlInSeconds) {
        LeaseGrantResponse leaseGrantResponse = leaseBlockingStub.leaseGrant(
                LeaseGrantRequest.newBuilder().setTTL(leaseTtlInSeconds).build());
        final long leaseId = leaseGrantResponse.getID();
        checkState(leaseId > 0, "fail to grant a valid lease: leaseId=s%", leaseId);
        checkState(leaseGrantResponse.getTTL() == leaseTtlInSeconds,
                   "please set suitable TTL:TTL required=%s, TTL in response=%s", leaseTtlInSeconds,
                   leaseGrantResponse.getTTL());
        logger.info("success to grant a lease: leaseId={}, TTL={}", leaseId, leaseTtlInSeconds);
        return leaseId;
    }

    void leaseRevoke(long leaseId) {
        if (leaseId <= 0) {
            return;
        }
        leaseBlockingStub.leaseRevoke(LeaseRevokeRequest.newBuilder().setID(leaseId).build());
        logger.info("success to revoke lease: leaseId = {}", leaseId);
    }


    private String instanceStatusKey(ServiceInstance serviceInstance) {
        return KeyUtil.instanceStatusKey(serviceInstance.getGroup(), serviceInstance.getService(),
                                         serviceInstance.getIp(), serviceInstance.getPort());
    }

    private Optional<ServiceInstanceStatus> instanceStatusQuery(String group, String service, String ip, int port) {
        final String instanceStatusKey = KeyUtil.instanceStatusKey(group, service, ip, port);

        RangeRequest rangeRequest = RangeRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(instanceStatusKey))
                .build();
        RangeResponse rangeResponse = kvBlockingStub.range(rangeRequest);
        if (rangeResponse.getCount() == 0) {
            return Optional.empty();
        }


        String dataJson = rangeResponse.getKvs(0).getValue().toStringUtf8();
        ServiceInstanceStatus instanceStatus = ValueUtil.fromStatusJson(dataJson);
        return Optional.of(instanceStatus);
    }

    private Optional<ServiceInstanceData> instanceDataQuery(String group, String service, String ip, int port) {
        final String instanceDataKey = KeyUtil.instanceDataKey(group, service, ip, port);

        RangeRequest rangeRequest = RangeRequest.newBuilder().setKey(ByteString.copyFromUtf8(instanceDataKey)).build();
        RangeResponse rangeResponse = kvBlockingStub.range(rangeRequest);
        if (rangeResponse.getCount() == 0) {
            return Optional.empty();
        }

        String dataJson = rangeResponse.getKvs(0).getValue().toStringUtf8();
        ServiceInstanceData instanceData = ValueUtil.fromDataJson(dataJson);
        return Optional.of(instanceData);
    }
}

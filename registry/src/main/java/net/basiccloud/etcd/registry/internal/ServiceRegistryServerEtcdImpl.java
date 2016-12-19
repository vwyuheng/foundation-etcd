package net.basiccloud.etcd.registry.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;

import net.basiccloud.registry.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Preconditions.checkNotNull;
import static net.basiccloud.registry.ServiceInstanceStatus.Status.*;

/**
 * Etcd3 implementation of ServiceRegistryServer.
 */
public class ServiceRegistryServerEtcdImpl extends AbstractServiceRegistryEtcdImpl implements ServiceRegistryServer<EtcdRegisterId> {

    private static Logger logger = LoggerFactory.getLogger(ServiceRegistryServerEtcdImpl.class);
    @VisibleForTesting
    static final Map<String, ServiceInstance> serviceInstanceMap = Maps.newHashMap();
    private static final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    private static final int LEASE_TTL = 5;

    private ServiceAliveKeeper serviceAliveKeeper;

    @VisibleForTesting
    ServiceRegistryServerEtcdImpl(){
        super();
    }
    /**
     * create service registry server etcd implement
     *
     * @param connection service registry connnection
     */
    public ServiceRegistryServerEtcdImpl(ServiceRegistryConnection connection) {
        super(connection);
        serviceAliveKeeper = new ServiceAliveKeeper(leaseStub);
        scheduledExecutorService.scheduleWithFixedDelay(() -> serviceInstanceMap.values().forEach(this::doRegister), 10,
                10,
                TimeUnit.SECONDS);
    }

    @Override
    public EtcdRegisterId register(ServiceInstance serviceInstance) {
        checkNotNull(serviceInstance, "serviceInstance should not be null");
        checkNotNull(serviceInstance.getData(), "data of serviceInstance should not be null");
        checkNotNull(serviceInstance.getStatus(), "status of serviceInstance should not be null");

        registerPreCheck(serviceInstance);

        return doRegister(serviceInstance);
    }

    private void registerPreCheck(ServiceInstance serviceInstance) {
        ServiceInstanceStatus.Status status = serviceInstance.getStatus().getStatus();
        //TODO sky register preCheck,how to check work mode?
        if (status.equals(OFFLINE)) {
            throw new UnsupportedOperationException("status is set to OFFLINE, please use deregister() method");
        }
    }

    private EtcdRegisterId doRegister(ServiceInstance serviceInstance) {
        Optional<ServiceInstanceData> dataOptional = instanceDataQuery(serviceInstance);
        Optional<ServiceInstanceStatus> statusOptional = instanceStatusQuery(serviceInstance);

        //there are 3 cases for above two optional
        if (dataOptional.isPresent() && statusOptional.isPresent() && statusOptional.get().isOnline()) {
            //case1:both instance data and status exist and status is online
            logger.trace("do service register,data is exists,status is exists and status is online");
            return updateDataIfChanged(serviceInstance, dataOptional.get(), statusOptional.get());
        }

        if (statusOptional.isPresent() && !dataOptional.isPresent()) {
            // case2: instance data is not found, but instance status exist
            // this is a tricky case, it should not happen
            // perhaps the instance data is removed by some mistaken
            // we should clean the status, in fact, revoke the lease if present
            // and then do standard register
            logger.trace("do service register,data is not exists and status is exists");
            leaseRevoke(statusOptional.get().getLeaseId());
        }
        return standardRegister(serviceInstance);
    }

    private EtcdRegisterId standardRegister(ServiceInstance serviceInstance) {
        logger.info("do standard register,instance ={}", serviceInstance);
        //1.save instance data
        instanceDataSave(serviceInstance);
        //2.create etcd lease id
        final long leaseId = leaseGrant(LEASE_TTL);
        //3.save instance status
        ServiceInstanceStatus updatedStatus = ServiceInstanceStatus.newBuilder(serviceInstance.getStatus())
                .setLeaseId(leaseId).build();
        ServiceInstance updatedInstance = ServiceInstance.newBuilder(serviceInstance).setStatus(updatedStatus).build();
        instanceStatusSave(updatedInstance, leaseId);
        //4.add keep alive for lease id
        serviceAliveKeeper.addKeepAlive(leaseId);
        //5.add check self task
        serviceInstanceMap.put(serviceInstance.getId(), serviceInstance);
        return new EtcdRegisterId(leaseId, updatedInstance);
    }

    private EtcdRegisterId updateDataIfChanged(ServiceInstance serviceInstance, ServiceInstanceData serviceInstanceData,
                                               ServiceInstanceStatus existStatus) {
        if (serviceInstance.getData().equals(serviceInstanceData)) {
            // no data changed, just return exist data and status
            ServiceInstance updatedInstance = ServiceInstance.newBuilder(serviceInstance).setStatus(
                    existStatus).build();
            return new EtcdRegisterId(existStatus.getLeaseId(), updatedInstance);
        }

        // data changed, update etcd to save new instance data
        instanceDataSave(serviceInstance);
        ServiceInstance updatedInstance = ServiceInstance.newBuilder(serviceInstance).setStatus(existStatus).build();
        return new EtcdRegisterId(existStatus.getLeaseId(), updatedInstance);
    }


    @Override
    public void deregister(EtcdRegisterId registerId) {
        checkNotNull(registerId, "registerId should not be null");
        checkNotNull(registerId.getInstance(), "service instance in registerId should not be null");

        Optional<ServiceInstanceStatus> statusOptional = instanceStatusQuery(registerId.getInstance());
        if (!statusOptional.isPresent()) {
            // tricky case, it should not happen
            // Anyway we need handle it
            // what should we do? Take it as normal deregister
            logger.warn("instance status no found in etcd when deregister: instance={}", registerId.getInstance());
            standardDeregister(registerId);
            return;
        }

        ServiceInstanceStatus existStatus = statusOptional.get();
        if (existStatus.isOnline()) {
            standardDeregister(registerId);
        } else {
            // nothing to do
            logger.warn("current instance status is OFFLINE when do deregister, we can do nothing");
        }
    }

    private void standardDeregister(EtcdRegisterId registerId) {
        // TODO: @Andy, how to revoke a leaseId without notifications to the clients?
        // we have to steps: 1. revoke lease 2. update status to offline, how to combine them to one?
        logger.info("do standard deregister,instance ={}", registerId.getInstance());
        //1.remove check self task
        serviceInstanceMap.remove(registerId.getInstance().getId());
        //2.stop keep alive
        serviceAliveKeeper.removeKeepAlive(registerId.getLeaseId());
        //3.revoke lease
        leaseRevoke(registerId.getLeaseId());
        //4.add new status key with offline
        ServiceInstanceStatus offlineStatus = ServiceInstanceStatus.newBuilder(registerId.getInstance().getStatus())
                .asOffline().setLastUpdateTime(System.currentTimeMillis()).setLeaseId(0).build();
        ServiceInstance offlineInstance = ServiceInstance.newBuilder(registerId.getInstance())
                .setStatus(offlineStatus).build();
        instanceStatusSave(offlineInstance);
    }
}

package net.basiccloud.etcd.registry.internal;

import net.basiccloud.registry.RegisterId;
import net.basiccloud.registry.ServiceInstance;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * etcd3 implementation of RegisterId.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class EtcdRegisterId implements RegisterId {

    private final long leaseId;

    private final ServiceInstance instance;

    /**
     * create EtcdRegisterId with service instance
     * @param instance Service instance
     */
    public EtcdRegisterId(ServiceInstance instance) {
        checkNotNull(instance, "instance should not bu null");
        this.leaseId = 0;
        this.instance = instance;
    }

    /**
     *create EtcdRegisterId with lease id and service instance
     * @param leaseId lease id
     * @param instance service instance
     */
    public EtcdRegisterId(long leaseId, ServiceInstance instance) {
        checkArgument(leaseId > 0, "leaseId should be positive");
        checkNotNull(instance, "instance should not bu null");
        this.leaseId = leaseId;
        this.instance = instance;
    }

    public long getLeaseId() {
        return leaseId;
    }

    public ServiceInstance getInstance() {
        return instance;
    }
}

package net.basiccloud.etcd.registry.internal;

import com.google.common.annotations.VisibleForTesting;

import com.coreos.etcd3.api.LeaseGrpc;
import com.coreos.etcd3.api.LeaseKeepAliveRequest;
import com.coreos.etcd3.api.LeaseKeepAliveResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import io.grpc.stub.StreamObserver;

/**
 * keep alive etcd lease Id for server
 */
class ServiceAliveKeeper {

    private static Logger logger = LoggerFactory.getLogger(ServiceAliveKeeper.class);

    private static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    @VisibleForTesting
    static Set<Long> leaseIdSets = new HashSet<>(10);

    ServiceAliveKeeper(LeaseGrpc.LeaseStub leaseStub) {
        StreamObserver<LeaseKeepAliveRequest> streamObserver = leaseStub.leaseKeepAlive(
                new StreamObserver<LeaseKeepAliveResponse>() {
                    @Override
                    public void onNext(LeaseKeepAliveResponse value) {
                        logger.trace("lease keep alive , leaseId = {}", value.getID());
                    }

                    @Override
                    public void onError(Throwable t) {
                        logger.error("keep alive error", t);
                    }

                    @Override
                    public void onCompleted() {
                        logger.info("keep alive on completed");
                    }
                });
        scheduledExecutorService.scheduleWithFixedDelay(() -> leaseIdSets.forEach(leaseId -> {
            try {
                streamObserver.onNext(LeaseKeepAliveRequest.newBuilder().setID(leaseId).build());
            } catch (Exception e) {
                logger.warn("service keep alive error for leaseId = " + leaseId, e);
            }
        }), 1, 1, TimeUnit.SECONDS);
    }

    void addKeepAlive(long leaseId) {
        leaseIdSets.add(leaseId);
    }

    void removeKeepAlive(long leaseId) {
        leaseIdSets.remove(leaseId);
    }
}

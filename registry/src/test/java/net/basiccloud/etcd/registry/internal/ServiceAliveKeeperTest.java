package net.basiccloud.etcd.registry.internal;

import com.coreos.etcd3.api.LeaseGrpc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import io.grpc.stub.StreamObserver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({LeaseGrpc.LeaseStub.class})
@PowerMockIgnore("javax.management.*")
public class ServiceAliveKeeperTest {

    @Mock
    private LeaseGrpc.LeaseStub leaseStub;
    @InjectMocks
    private ServiceAliveKeeper serviceAliveKeeper;

    private static long LEASE_ID = 123123;

    @SuppressWarnings("unchecked")
    @Test
    public void startKeep() throws Exception {
        StreamObserver streamObserver = mock(StreamObserver.class);
        when(leaseStub.leaseKeepAlive(streamObserver)).thenReturn(mock(StreamObserver.class));
        serviceAliveKeeper.addKeepAlive(LEASE_ID);
        verify(leaseStub).leaseKeepAlive(any());
        assertThat(ServiceAliveKeeper.leaseIdSets.size()).isEqualTo(1);
    }

    @Test
    public void stopKeep() throws Exception {
        serviceAliveKeeper.removeKeepAlive(LEASE_ID);
        assertThat(ServiceAliveKeeper.leaseIdSets.size()).isEqualTo(0);
    }

}
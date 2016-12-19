package net.basiccloud.etcd;

import com.coreos.etcd3.api.*;
import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class EtcdConnectionBuilderTest {

    @Test
    public void build() throws Exception {
        ManagedChannel managedChannel = EtcdConnectionBuilder.newBuilder().etcdUri("etcd://127.0.0.1").build();

//        NettyChannelBuilder nettyChannelBuilder = NettyChannelBuilder.forAddress("127.0.0.1", 2379)
//                //NettyChannelBuilder nettyChannelBuilder = NettyChannelBuilder.forTarget(etcdUri)
//                .usePlaintext(true);
//        ManagedChannel managedChannel = nettyChannelBuilder.build();

        KVGrpc.KVBlockingStub kvBlockingStub = KVGrpc.newBlockingStub(managedChannel);

        //verify
        PutRequest putRequest = PutRequest.newBuilder().setKey(ByteString.copyFrom("aaa", StandardCharsets.UTF_8))
                .setValue(ByteString.copyFrom("aaa111", StandardCharsets.UTF_8)).build();
        PutResponse putResponse = kvBlockingStub.put(putRequest);
        assertThat(putResponse).isNotNull();
        RangeResponse rangeResponse = kvBlockingStub.range(RangeRequest.newBuilder()
                .setKey(ByteString.copyFrom("aaa", StandardCharsets.UTF_8)).build());
        assertThat(rangeResponse.getCount()).isEqualTo(1);
        assertThat(rangeResponse.getKvs(0).getValue().toString(StandardCharsets.UTF_8)).isEqualTo("aaa111");
    }

}
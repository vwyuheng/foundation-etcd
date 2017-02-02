package net.basiccloud.etcd;

import com.google.common.base.Strings;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;

import net.basiccloud.etcd.internal.EtcdNameResolverProvider;

import java.net.URI;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import static net.basiccloud.etcd.internal.EtcdNameResolverProvider.ETCD_SCHEME;

/**
 * Etcd client builder.
 */
public class EtcdConnectionBuilder {

    private String etcdUri;

    private EtcdConnectionBuilder() {
        // no public constructor
    }

    /**
     * create new etcd Connection builder
     *
     * @return EtcdConnectionBuilder
     */
    public static EtcdConnectionBuilder newBuilder() {
        return new EtcdConnectionBuilder();
    }

    /**
     * set builder etcd uri
     *
     * @param etcdUri etcd uri address
     * @return EtcdConnectionBuilder
     */
    public EtcdConnectionBuilder etcdUri(String etcdUri) {
        checkArgument(!Strings.isNullOrEmpty(etcdUri), "etcdUri should not be null or empty");
        checkScheme(etcdUri);

        this.etcdUri = etcdUri;
        return this;
    }

    private void checkScheme(String etcdUri) {
        URI uri;
        try {
            uri = new URI(etcdUri);
        } catch (Exception e) {
            throw new IllegalArgumentException("etcdUri is not a valid URI: etcdUri=" + etcdUri, e);
        }
        checkArgument(uri.getScheme().equals(ETCD_SCHEME), "Scheme of etcdUri should be '%s': etcdUri=%s",
                ETCD_SCHEME, etcdUri);
    }

    /**
     * build managedChannel with EtcdConnectionBuilder
     *
     * @return ManagedChannel
     */
    public ManagedChannel build() {
        checkState(etcdUri != null, "please set etcdUri before build");

        NettyChannelBuilder nettyChannelBuilder = NettyChannelBuilder.forTarget(etcdUri)
                // we use SPI to load EtcdNameResolverProvider, so comment this line
                //.nameResolverFactory(new EtcdNameResolverProvider())
                .usePlaintext(true);
        return nettyChannelBuilder.build();
    }
}

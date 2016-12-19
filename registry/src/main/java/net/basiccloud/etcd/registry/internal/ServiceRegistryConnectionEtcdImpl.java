package net.basiccloud.etcd.registry.internal;

import com.google.common.base.Strings;

import io.grpc.ManagedChannel;

import net.basiccloud.etcd.EtcdConnectionBuilder;
import net.basiccloud.registry.ParameterParser;
import net.basiccloud.registry.ServiceRegistryConnection;
import net.basiccloud.registry.ServiceRegistryConnectionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

/**
 * etcd implementation of ServiceRegistryConnection.
 */
@SuppressWarnings("unused")
public class ServiceRegistryConnectionEtcdImpl implements ServiceRegistryConnection {

    private static Logger logger = LoggerFactory.getLogger(ServiceRegistryConnectionEtcdImpl.class);

    public static ServiceRegistryConnectionEtcdImpl buildFromParameters(Map<String, String> parameters) {
        Optional<String> registryUrlOptional = ParameterParser.parseRegistryUrl(parameters);
        if (!registryUrlOptional.isPresent()) {
            throw new ServiceRegistryConnectionException("can not get registryUri");
        }

        String registryUrl = registryUrlOptional.get();
        return new ServiceRegistryConnectionEtcdImpl(registryUrl);
    }

    private final String registryUri;
    private ManagedChannel managedChannel;

    ServiceRegistryConnectionEtcdImpl(String registryUri) {
        checkArgument(!Strings.isNullOrEmpty(registryUri), "registryUri should not be null or empty");
        this.registryUri = registryUri;
    }

    @Override
    public void connect() {
        logger.debug("try to connect to etcd: registryUri={}", registryUri);
        try {
            managedChannel = EtcdConnectionBuilder.newBuilder().etcdUri(registryUri).build();
            logger.info("success to connect to etcd: registryUri={}", registryUri);
        } catch (Exception e) {
            logger.error("success to connect to etcd: registryUri=" + registryUri, e);
            throw new ServiceRegistryConnectionException("fail to connect to etcd", e);
        }

    }

    public String getRegistryUri() {
        return registryUri;
    }

    ManagedChannel getManagedChannel() {
        checkState(this.managedChannel != null, "not connected");
        return managedChannel;
    }
}

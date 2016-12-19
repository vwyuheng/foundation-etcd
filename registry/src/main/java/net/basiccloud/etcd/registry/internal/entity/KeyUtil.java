package net.basiccloud.etcd.registry.internal.entity;

import net.basiccloud.registry.ServiceInstance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Key utility in etcd registry.
 */
@SuppressWarnings("WeakerAccess")
public class KeyUtil {

    private static Logger logger = LoggerFactory.getLogger(KeyUtil.class);

    public static final String ROOT = "registry";
    public static final String DATA = "data";
    public static final String STATUS = "status";
    public static final char SEPARATOR = '/';
    public static final String SEPARATOR_ADDRESS = ":";
    public static final String SEPARATOR_STRING = "" + SEPARATOR;

    private static final String ALL_KEY_PREFIX = generatedDirectoryPath(ROOT);
    private static final String DATA_KEY_POSTFIX = generatedFilePath(DATA);
    private static final String STATUS_KEY_POSTFIX = generatedFilePath(STATUS);
    private static final char END_CHARACTER = (char) 254;
    private static final String END_STRING = "" + END_CHARACTER;

    private static String generatedDirectoryPath(String... names) {
        StringBuilder builder = new StringBuilder(64);
        builder.append(SEPARATOR);
        for (String name : names) {
            builder.append(name).append(SEPARATOR);
        }
        return builder.toString();
    }

    private static String generatedFilePath(String... names) {
        StringBuilder builder = new StringBuilder(64);
        for (String name : names) {
            builder.append(SEPARATOR).append(name);
        }
        return builder.toString();
    }

    public static String instanceDataKey(String group, String service, String ip, int port) {
        return generatedFilePath(ROOT, group, service, ip + SEPARATOR_ADDRESS + port, DATA);
    }

    public static String instanceStatusKey(String group, String service, String ip, int port) {
        return generatedFilePath(ROOT, group, service, ip + SEPARATOR_ADDRESS + port, STATUS);
    }

    public static String instanceDiscoverBeginKey(String group, String service) {
        return generatedDirectoryPath(ROOT, group, service);
    }

    public static String instanceDiscoverEndKey(String group, String service) {
        return generatedFilePath(ROOT, group, service, END_STRING);
    }

    public static boolean isInstanceDataKey(String key) {
        return key.startsWith(ALL_KEY_PREFIX) && key.endsWith(DATA_KEY_POSTFIX);
    }

    public static boolean isInstanceStatusKey(String key) {
        return key.startsWith(ALL_KEY_PREFIX) && key.endsWith(STATUS_KEY_POSTFIX);
    }

    public static Optional<ServiceInstance> parseInstanceDataKey(String key) {
        return parseInstanceKey(key, DATA_KEY_POSTFIX);
    }

    public static Optional<ServiceInstance> parseInstanceStatusKey(String key) {
        return parseInstanceKey(key, STATUS_KEY_POSTFIX);
    }

    private static Optional<ServiceInstance> parseInstanceKey(String key, String keyPostfix) {
        if (!key.startsWith(ALL_KEY_PREFIX) || !key.endsWith(keyPostfix)) {
            return Optional.empty();
        }

        String[] strings = key.split(SEPARATOR_STRING);
        if (strings.length != 6) {
            return Optional.empty();
        }

        try {
            final String group = strings[2];
            final String service = strings[3];
            String ipPort = strings[4];
            String[] ipPortStrings = ipPort.split(SEPARATOR_ADDRESS);
            final String ip = ipPortStrings[0];
            final int port = Integer.valueOf(ipPortStrings[1]);

            ServiceInstance serviceInstance = ServiceInstance.newBuilder().setGroup(group)
                    .setService(service)
                    .setIp(ip)
                    .setPort(port)
                    .build();
            return Optional.of(serviceInstance);
        } catch (Exception e) {
            logger.warn("fail to parse service instance key: key={},case,{}", key, e);
            return Optional.empty();
        }
    }

//    public static String getServiceLookupBeginKey(String group, String service) {
//        return SEPARATOR + REGISTER_ROOT + SEPARATOR + group + SEPARATOR + service + SEPARATOR;
//    }
//
//    public static String getServiceLookupEndKey(String group, String service) {
//        return SEPARATOR + REGISTER_ROOT + SEPARATOR + group + SEPARATOR + service + SEPARATOR
//                // add an additional END_CHARACTER
//                + END_CHARACTER;
//    }
//
//    public static String getServiceRegisterKey(String groupName, String serviceName, String ip, int port) {
//        return SEPARATOR + REGISTER_ROOT + SEPARATOR + groupName + SEPARATOR + serviceName + SEPARATOR + ip + SEPARATOR + port;
//    }
//
//    public static String getCleanRegistryBeginKey() {
//        return SEPARATOR + REGISTER_ROOT + SEPARATOR;
//    }
//
//    public static String getCleanRegistryEndKey() {
//        return SEPARATOR + REGISTER_ROOT + SEPARATOR +
//                // add an additional END_CHARACTER
//                END_CHARACTER;
//    }
//
//    public static void parseServiceKey(String key, ServiceInstance.Builder builder) {
//        // "/registry/${groupName}/${serviceName}/${ip}/${port}"
//
//        String[] strings = key.split(SEPARATOR);
//        if (strings.length != 6 || !strings[1].equals(REGISTER_ROOT)) {
//            throw new WrongKeyFormatException("invalid key for service instance: key=" + key);
//        }
//
//        try {
//            builder.group(strings[2])
//                    .name(strings[3])
//                    .ip(strings[4])
//                    .port(Integer.valueOf(strings[5]));
//        } catch (Exception e) {
//            throw new WrongKeyFormatException("invalid key for service instance: key=" + key, e);
//        }
//    }

    private KeyUtil() {
        // no instance
    }
}

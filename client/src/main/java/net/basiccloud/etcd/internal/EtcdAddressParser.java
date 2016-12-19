package net.basiccloud.etcd.internal;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Helper class to parse etcd address.
 */
class EtcdAddressParser {

    static class IpPortPair {
        private final String ip;
        private final int port;

        IpPortPair(String ip, int port) {
            this.ip = ip;
            this.port = port;
        }

        String getIp() {
            return ip;
        }

        int getPort() {
            return port;
        }
    }

    private EtcdAddressParser() {
        // no instance
    }


    static List<IpPortPair> parse(String etcdContent, int defaultPort) throws UnknownHostException {
        String[] etcdArray = etcdContent.split(",");
        List<IpPortPair> resolvedAddress = new ArrayList<>(etcdArray.length);
        for (String etcd : etcdArray) {
            resolvedAddress.addAll(parseOneAddress(etcd, defaultPort));
        }
        return resolvedAddress;
    }

    static List<String> parseIpFromHost(String host) throws UnknownHostException {
        InetAddress[] addresses = InetAddress.getAllByName(host);
        List<String> ipList = new ArrayList<>(addresses.length);
        for (InetAddress inetAddress : addresses) {
            ipList.add(inetAddress.getHostAddress());
        }
        return ipList;
    }

    private static List<IpPortPair> parseOneAddress(String etcd, int defaultPort) throws UnknownHostException {
        String[] addressPortPair = etcd.split(":");
        final String address = addressPortPair[0].trim();
        final int port = parsePort(addressPortPair, defaultPort);

        List<IpPortPair> result = new ArrayList<>();
        List<String> ipList = parseIpFromHost(address);
        for (String ip : ipList) {
            result.add(new IpPortPair(ip, port));
        }

        return result;
    }


    private static int parsePort(String[] addressPortPair, int defaultPort) {
        int port = defaultPort;
        if (addressPortPair.length > 1) {
            try {
                port = Integer.valueOf(addressPortPair[1].trim());
            } catch (Exception e) {
                throw new IllegalArgumentException("invalid port in etcd address: port=" + addressPortPair[1], e);
            }
        }
        return port;
    }
}

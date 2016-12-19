package net.basiccloud.etcd.internal;

import org.junit.Test;

import java.net.UnknownHostException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EtcdAddressParserTest {
    private int defaultPort = 2379;

    @Test
    public void parse_ipWithPort() throws Exception {
        final String input = "127.0.0.1:1111";
        List<EtcdAddressParser.IpPortPair> ipPortPairList = EtcdAddressParser.parse(input, defaultPort);
        assertThat(ipPortPairList.size()).isEqualTo(1);
        EtcdAddressParser.IpPortPair ipPortPair = ipPortPairList.get(0);
        assertThat(ipPortPair.getIp()).isEqualTo("127.0.0.1");
        assertThat(ipPortPair.getPort()).isEqualTo(1111);
    }

    @Test
    public void parse_ipWithoutPort() throws Exception {
        final String input = "127.0.0.1";
        List<EtcdAddressParser.IpPortPair> ipPortPairList = EtcdAddressParser.parse(input, defaultPort);
        assertThat(ipPortPairList.size()).isEqualTo(1);
        EtcdAddressParser.IpPortPair ipPortPair = ipPortPairList.get(0);
        assertThat(ipPortPair.getIp()).isEqualTo("127.0.0.1");
        assertThat(ipPortPair.getPort()).isEqualTo(defaultPort);
    }

    @Test
    public void parse_hostWithPort() throws Exception {
        final String input = "www.baidu.com:1111";
        List<EtcdAddressParser.IpPortPair> ipPortPairList = EtcdAddressParser.parse(input, defaultPort);

        System.out.println("input = " + input);
        for(EtcdAddressParser.IpPortPair ipPortPair : ipPortPairList) {
            System.out.println("parsed result = " + ipPortPair.getIp() + ":" + ipPortPair.getPort());
        }

        assertThat(ipPortPairList.size()).isGreaterThan(1);
        EtcdAddressParser.IpPortPair ipPortPair = ipPortPairList.get(0);
        assertThat(ipPortPair.getPort()).isEqualTo(1111);
    }

    @Test
    public void parse_hostWithoutPort() throws Exception {
        final String input = "www.baidu.com";
        List<EtcdAddressParser.IpPortPair> ipPortPairList = EtcdAddressParser.parse(input, defaultPort);

        System.out.println("input = " + input);
        for(EtcdAddressParser.IpPortPair ipPortPair : ipPortPairList) {
            System.out.println("parsed result = " + ipPortPair.getIp() + ":" + ipPortPair.getPort());
        }

        assertThat(ipPortPairList.size()).isGreaterThan(1);
        EtcdAddressParser.IpPortPair ipPortPair = ipPortPairList.get(0);
        assertThat(ipPortPair.getPort()).isEqualTo(defaultPort);
    }

    @Test
    public void parse_mix() throws Exception {
        final String input = "www.baidu.com:22222, 127.0.0.1:1111, www.baidu.com, 127.0.0.1";
        List<EtcdAddressParser.IpPortPair> ipPortPairList = EtcdAddressParser.parse(input, defaultPort);
        assertThat(ipPortPairList.size()).isGreaterThan(1);
        System.out.println("input = " + input);
        for(EtcdAddressParser.IpPortPair ipPortPair : ipPortPairList) {
            System.out.println("parsed result = " + ipPortPair.getIp() + ":" + ipPortPair.getPort());
        }
    }

    @Test
    public void parse_wrong_emptyPort() throws Exception {
        final String input = "127.0.0.1:";
        List<EtcdAddressParser.IpPortPair> ipPortPairList = EtcdAddressParser.parse(input, defaultPort);
        assertThat(ipPortPairList.size()).isEqualTo(1);
        EtcdAddressParser.IpPortPair ipPortPair = ipPortPairList.get(0);
        assertThat(ipPortPair.getIp()).isEqualTo("127.0.0.1");
        assertThat(ipPortPair.getPort()).isEqualTo(defaultPort);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parse_wrong_invalidPort() throws Exception {
        final String input = "127.0.0.1:sdf";
        EtcdAddressParser.parse(input, defaultPort);
    }

    @Test(expected = UnknownHostException.class)
    public void parse_wrong_invalidHost() throws Exception {
        final String input = "invalid_host:123";
        EtcdAddressParser.parse(input, defaultPort);
    }

    @Test
    public void parseIpFromHost_hostname() throws Exception {
        final String input = "www.baidu.com";
        List<String> ipList = EtcdAddressParser.parseIpFromHost(input);
        assertThat(ipList.size()).isGreaterThan(1);
        for(String ip : ipList) {
            System.out.println(input + " is parsed to ip：" + ip);
        }
    }

    @Test
    public void parseIpFromHost_ip() throws Exception {
        final String input = "14.215.177.37";
        List<String> ipList = EtcdAddressParser.parseIpFromHost(input);
        assertThat(ipList.size()).isEqualTo(1);
        assertThat(input).isEqualTo(ipList.get(0));
    }

}
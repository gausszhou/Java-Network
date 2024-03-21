package com.example.network.lesson03;

/**
 * 1. 如何准确定位到网络上的一台或多台主机 ip port
 * 2. 主机后如何通信 tcp udp
 */


import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ipv4 32位   4个字节  42 亿
 * ipv6 128位
 */

public class Application {
    public static void main(String[] args) {
        getLocalHost();
        getBaiduHost();
    }

    static void getLocalHost() {
        try {
            InetAddress localHost1 = InetAddress.getLocalHost();
            InetAddress localHost2 = InetAddress.getByName("localhost");
            InetAddress localHost3 = InetAddress.getByName("127.0.0.1");
            System.out.println(localHost1.getHostAddress()); // 192.168.4.104 实际的局域网 IP
            System.out.println(localHost2.getHostAddress()); // 127.0.0.1
            System.out.println(localHost3.getHostAddress()); // 127.0.0.1
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    static void getBaiduHost() {
        try {
            InetAddress baidu = InetAddress.getByName("www.baidu.com");
            System.out.println(baidu); // www.baidu.com/183.2.172.185

            System.out.println(baidu.getAddress()); // 很慢 [B@1b6d3586
            System.out.println(baidu.getCanonicalHostName()); // 183.2.172.185

            System.out.println(baidu.getHostAddress()); // ip
            System.out.println(baidu.getHostName()); // 域名 www.baidu.com

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}

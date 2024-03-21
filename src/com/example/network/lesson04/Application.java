package com.example.network.lesson04;

/**
 * 端口表示计算机上某个程序的一个进程
 * 1. 不同的进程有不同的端口号，
 * 2. 端口范围 0-65535
 * 3. 单个协议下端口号不能冲突 TCP 0-65535 UDP 0-65535
 * 4. 公有端口 0-1023 常用协议默认端口 HTTP 80 HTTPS 443 FTP 21 SSH 22 Telnet 23
 * 5. 程序注册端口 1024-49151  常用软件端口 Tomcat 8080 MySQL 3306 Redis 6379 Oracle 1521
 * 6. 动态端口 49152-65535
 */

import java.net.InetSocketAddress;

/**
 * netstat -ano
 * netstat -ano | findstr 443 查看指定端口
 * tasklist | grep chrome // 查看指定进程
 * 活动连接
 *
 *   协议  本地地址          外部地址        状态           PID
 *   TCP    0.0.0.0:135            0.0.0.0:0              LISTENING       1140
 *   TCP    0.0.0.0:445            0.0.0.0:0              LISTENING       4
 *   TCP    0.0.0.0:1024           0.0.0.0:0              LISTENING       912
 *   TCP    0.0.0.0:1025           0.0.0.0:0              LISTENING       3240
 */

public class Application {
    public static void main(String[] args) {
        InetSocketAddress socket = new InetSocketAddress("127.0.0.1", 8080);
        System.out.println(socket.getAddress()); // 127.0.0.1/127.0.0.1
        System.out.println(socket.getHostName()); // 127.0.0.1
        System.out.println(socket.getPort()); // 8080
        System.out.println(socket.getHostString()); // 127.0.0.1
    }
}

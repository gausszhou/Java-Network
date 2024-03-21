package com.example.network.lesson06;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPClient {

    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            // 1. 知道服务器地址
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int port = 8080;
            // 2. 创建一个 socket 连接
            socket = new Socket(serverIP, port);
            // 3. 发送消息 IO 流
            outputStream = socket.getOutputStream();
            System.out.println("发送消息");
            outputStream.write("Hello".getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                socket.close();
                System.out.println("关闭");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}

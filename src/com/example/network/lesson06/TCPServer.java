package com.example.network.lesson06;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;
        try {
            // 1. 创建一个 socket
            serverSocket = new ServerSocket(8080);
            // 2. 等待客户端连接
            socket = serverSocket.accept();
            // 3. 读取客户端的消息
            inputStream = socket.getInputStream();
            outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            System.out.println("接收消息");
            System.out.println(outputStream.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                inputStream.close();
                socket.close();
                serverSocket.close();
                System.out.println("关闭");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

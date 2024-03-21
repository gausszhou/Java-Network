package com.example.network.lesson07;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        // inputStream -> buffer -> fileOutputStream
        try {
            // 1. 创建一个 socket
            serverSocket = new ServerSocket(8080);
            // 2. 等待客户端连接
            socket = serverSocket.accept(); // 阻塞式监听
            // 3. 获取输入流
            System.out.println("接收文件开始");
            inputStream = socket.getInputStream();
            fileOutputStream = new FileOutputStream(new File("./out/receive.png"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
            System.out.println("接收文件完成");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
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

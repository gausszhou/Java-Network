package com.example.network.lesson07;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) {
        Socket socket = null;
        FileInputStream fileInputStream = null;
        OutputStream outputStream = null;
        // fileStream -> buffer -> outputStream
        try {
            // 1. 创建一个 socket 连接
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8080);
            // 2. 创建一个输出流
            outputStream = socket.getOutputStream();
            System.out.println("发送文件开始");
            // 3. 读取文件
            fileInputStream = new FileInputStream(new File("./file/01.png"));
            // 4. 写文件流
            byte[] buffer = new byte[1024];
            int len;
            while((len = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0 ,len);
            }
            System.out.println("发送文件完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                outputStream.close();
                socket.close();
                System.out.println("关闭");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

package com.yqh.demo.bio;

import cn.hutool.core.util.IdUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/19
 * @subject 阻塞IO
 * @link
 * @desp
 *
 * C10K => 连接1万连接 => 开启1万个线程
 * C10M => 链接100万连接 => 开启100万个线程
 *
 */
public class SocketServer {

    public static void main(String[] args) throws IOException {
        
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            System.out.println("socket: wait connect ...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("socket: the clent connected ~~~");
            new Thread(() -> {
                try {
                    handler(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }

    private static void handler(Socket clientSocket) throws IOException {
        byte[] bytes = new byte[1024];
        System.out.println("handler: prepare to read ---");
        int response = clientSocket.getInputStream().read(bytes);
        System.out.println("handler: read over !!! response: " + response);
        if (response != -1) {
            System.out.println("handler: receive message:" + new String(bytes, 0, response));
        }
    }


}

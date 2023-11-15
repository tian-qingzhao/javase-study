package com.tqz.javase.study.socket.tcp.login4;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端使用多线程接收多个用户的请求
 *
 * @author tianqingzhao
 * @since 2023-05-11 21:07
 */
public class LoginServer4 {

    public static void main(String[] args) throws IOException {
        //1.创建一个ServerSocket
        ServerSocket serverSocket = new ServerSocket(8080);
        int i = 1;
        while (true) {
            //2.使用ServerSocket监听用户的请求
            Socket socket = serverSocket.accept();
            //开启一个线程，处理用户请求
            new LoginThread(socket).start();
            //获取请求方是第几个访问的客户端 以及IP地址
            InetAddress ia = socket.getInetAddress();
            System.out.println("这是第" + i++ + "个请求的用户,对方的IP地址：" + ia.getHostAddress());
        }
    }
}

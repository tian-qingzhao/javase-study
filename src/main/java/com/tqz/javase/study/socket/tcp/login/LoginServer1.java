package com.tqz.javase.study.socket.tcp.login;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 单向通信，客户端向服务端发送数据，服务端接收并打印
 *
 * @author tianqingzhao
 * @since 2023-05-11 20:14
 */
public class LoginServer1 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        // 阻塞接收请求
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String data = dataInputStream.readUTF();
        System.out.println("服务器接收到客户端数据：" + data);

        System.out.println("socket流是否关闭：" + socket.isClosed()); // false
        System.out.println("serverSocket流是否关闭：" + socket.isClosed()); // false
        dataInputStream.close();
        System.out.println("socket流是否关闭：" + socket.isClosed()); // true，说明输出流或输入流关闭之后，socket流也会被关闭
        System.out.println("serverSocket流是否关闭：" + serverSocket.isClosed()); // false，说明输出流或输入流关闭之后，serverSocket流不会被关闭
    }
}

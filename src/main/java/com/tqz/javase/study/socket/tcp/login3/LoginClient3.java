package com.tqz.javase.study.socket.tcp.login3;

import com.tqz.javase.study.socket.entity.User;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 双向通信-传输对象
 *
 * @author tianqingzhao
 * @since 2023-05-11 20:14
 */
public class LoginClient3 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8080);

        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        User user = new User("root", "123456");
        objectOutputStream.writeObject(user);

        objectOutputStream.close();
    }
}

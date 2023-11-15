package com.tqz.javase.study.socket.tcp.login4;

import com.tqz.javase.study.socket.entity.User;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 客户端登录
 *
 * @author tianqingzhao
 * @since 2023-05-11 21:07
 */
public class LoginClient4 {

    public static void main(String[] args) throws UnknownHostException, IOException {
        //1.创建一个Socket，连接服务器端
        Socket socket = new Socket(InetAddress.getLocalHost(), 8080);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        //2.发送数据给服务器端
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户姓名");
        String username = input.next();
        System.out.println("请输入用户密码");
        String password = input.next();

        User user = new User(username, password);

        oos.writeObject(user);

        //3.接收服务器端反馈并输出
        String result = dis.readUTF();
        System.out.println("服务器的反馈：" + result);
        //3.关闭资源
        dis.close();
        oos.close();
        socket.close();
    }
}

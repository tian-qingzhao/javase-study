package com.tqz.javase.study.socket.tcp.login4;

import com.tqz.javase.study.socket.entity.User;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author tianqingzhao
 * @since 2023-05-11 21:07
 */
public class LoginThread extends Thread {

    private Socket socket = null;

    public LoginThread(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream ois = null;
        DataOutputStream dos = null;
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            User user = (User) ois.readObject();
            System.out.println("服务端获取到用户信息：" + user);

            if ("root".equals(user.getName()) && "123456".equals(user.getPassword())) {
                dos.writeUTF("登录成功");
            } else {
                dos.writeUTF("登录失败");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}

package com.tqz.javase.study.socket.udp.ask4;

import com.tqz.javase.study.socket.entity.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP传输对象
 *
 * @author tianqingzhao
 * @since 2023-05-12 20:46
 */
public class AskClient4 {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8889);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ooos = new ObjectOutputStream(baos);
        ooos.writeObject(new User("root", "123456"));
        byte[] bytes = baos.toByteArray();

        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8089);
        socket.send(packet);

        byte[] buf = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(buf, buf.length);
        socket.receive(packet2);
        System.out.println("客户端接收服务端的数据：" + new String(packet2.getData(), 0, packet2.getLength()));

        socket.close();

    }
}

package com.tqz.javase.study.socket.udp.ask4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP传输对象
 *
 * @author tianqingzhao
 * @since 2023-05-12 20:46
 */
public class AskServer4 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket(8089);

        byte[] buf = new byte[1024];


        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        ByteArrayInputStream bais = new ByteArrayInputStream(packet.getData(), 0, packet.getLength());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object o = ois.readObject();

        System.out.println("服务端接收到客户端数据：" + o);

        String data = "你好，客户端";
        byte[] bytes = data.getBytes();
        DatagramPacket packet2 = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8889);
        socket.send(packet2);

        socket.close();
    }
}

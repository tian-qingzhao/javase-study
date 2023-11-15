package com.tqz.javase.study.socket.udp.ask3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * UDP多次双向通信
 *
 * @author tianqingzhao
 * @since 2023-05-12 19:42
 */
public class AskClient3 {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8889);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String data = scanner.nextLine();
            byte[] bytes = data.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8089);
            socket.send(packet);

            if ("bye".equals(data)) {
                break;
            }

            byte[] buf = new byte[1024];
            DatagramPacket packet2 = new DatagramPacket(buf, buf.length);
            socket.receive(packet2);
            System.out.println("客户端接收服务端的数据：" + new String(packet2.getData(), 0, packet2.getLength()));
        }

        socket.close();

    }
}

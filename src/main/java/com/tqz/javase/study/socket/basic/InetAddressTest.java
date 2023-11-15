package com.tqz.javase.study.socket.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author tianqingzhao
 * @since 2023-05-10 21:29
 */
public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost.toString());
        System.out.println(localHost.getHostAddress());
        System.out.println(localHost.getHostName());
        System.out.println(Arrays.toString(localHost.getAddress()));

        System.out.println("=============");
        InetAddress name = InetAddress.getByName("www.baidu.com");
        System.out.println(name);
        System.out.println(name.getHostAddress());
        System.out.println(name.getHostName());
        System.out.println(Arrays.toString(name.getAddress()));
    }
}

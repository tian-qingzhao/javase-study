package com.tqz.javase.study.socket.tcp.upload2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 使用tcp进行文件的上传，并得到服务器的反馈
 *
 * @author tianqingzhao
 * @since 2023-05-13 8:59
 */
public class UploadClient2 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        String path = "D:\\idea_workspace\\javaSE-study\\src\\main\\java\\com\\tqz\\javase\\study\\socket\\tcp" +
                "\\upload2\\test.txt";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());

        byte[] buf = new byte[1024];
        int len = 0;
        while (len != -1) {
            bufferedOutputStream.write(buf, 0, len);
            len = bufferedInputStream.read(buf);
        }
        bufferedOutputStream.flush(); //手动flush 不可少
        bufferedInputStream.close();
        //bufferedOutputStream.close(); // 1.flush 2.关闭流，关闭自己的同时也会关闭socket，因为socket和它有关系
        socket.shutdownOutput(); // 没有flush  2.会关闭bufferedOutputStream   没有关闭socket

        // 读取服务端的反馈
        InputStream inputStream = socket.getInputStream();

        // 1.使用字节流读取
        /*byte[] buf2 = new byte[1024];
        int len2 = inputStream.read(buf2);
        System.out.println(new String(buf2, 0, len2));*/

        // 2.使用字符流读取
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String data = bufferedReader.readLine();
        System.out.println(data);

        socket.close();

    }
}

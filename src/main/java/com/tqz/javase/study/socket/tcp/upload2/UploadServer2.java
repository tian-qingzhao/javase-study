package com.tqz.javase.study.socket.tcp.upload2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用tcp上传文件，并反馈给客户端
 *
 * @author tianqingzhao
 * @since 2023-05-13 9:02
 */
public class UploadServer2 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        Socket socket = serverSocket.accept();

        String path = "D:\\idea_workspace\\javaSE-study\\src\\main\\java\\com\\tqz\\javase\\study\\socket\\tcp" +
                "\\upload2\\test2.txt";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());

        byte[] buf = new byte[1024];
        int len = 0;
        while (len != -1) {
            bufferedOutputStream.write(buf, 0, len);

            len = bufferedInputStream.read(buf);
        }
        bufferedOutputStream.close();
        //bufferedInputStream.close(); // 1.flush 2.关闭流，关闭自己的同时也会关闭socket，因为socket和它有关系

        // 给客户端反馈
        OutputStream outputStream = socket.getOutputStream();

        // 1.使用字节流写
        /*String data = "上传成功";
        outputStream.write(data.getBytes(), 0, data.getBytes().length);
        outputStream.close();*/

        // 2.使用字符流写
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("上传成功");
        bufferedWriter.newLine();
        bufferedWriter.close();

        socket.close();
    }
}

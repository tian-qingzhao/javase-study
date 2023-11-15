package com.tqz.javase.study.socket.tcp.upload;

import java.io.*;

/**
 * 功能：复制文件的全部
 * 技能：BufferedInputStream和BufferedOutputStream
 *
 * <p>1.认识缓冲流
 * FileInputStream FileOutputStream 节点流
 * BufferedInputStream  BufferedOutputStream 处理流  过滤流  包装流
 *
 * <p>2.好处
 * 好处1：提供了缓冲区，提高了效率
 * 好处2：简化了操作（缓冲字符流）
 *
 * <p>3.原理
 * 输入流和输出流两端都提供了默认大小是8192的缓冲区（内存空间），其实就是一个字节数组
 * 具体原理看示意图
 * 减少了读写硬盘的次数，提高了效率
 *
 * <p>4.输出缓冲区的刷新
 * 1.手动刷新：flush()
 * 2.自动刷新：满后自动刷新
 * 3.close()时会先flush,再关闭底层流
 *
 * <p>5.关闭高层流，会自动关闭底层流
 *
 * @author tianqingzhao
 * @since 2023-05-13 8:56
 */
public class TestCopy2 {

    public static void main(String[] args) throws IOException {
        // 创建流（输入流和输出流）
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("d:/bjsxt.txt")));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:/bjsxt4.txt"));

        // 使用流（输入流和输出流）
        byte[] buf = new byte[1024];
        int len = bis.read(buf);

        while (len != -1) {
            // 写一个字节
            bos.write(buf, 0, len);
            // 输出
            //System.out.println((char)n);
            // 读一个字节
            len = bis.read(buf);
        }

        // 手动刷新（输出缓冲区内容写入文件）
        //bos.flush();
        // 关闭流（输入流和输出流）
        bis.close();
        bos.close();


    }

}

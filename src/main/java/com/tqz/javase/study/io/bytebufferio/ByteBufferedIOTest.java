package com.tqz.javase.study.io.bytebufferio;

import com.tqz.javase.study.io.Constant;

import java.io.*;

/**
 * 字节缓冲流
 *
 * <p>
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
 * <p>
 * 5.关闭高层流，会自动关闭底层流
 *
 * @author tianqingzhao
 * @since 2023-05-24 20:56
 */
public class ByteBufferedIOTest {

    public static void main(String[] args) throws IOException {
        //创建流（输入流和输出流）
        InputStream is = new FileInputStream(Constant.PATH1);
        OutputStream os = new FileOutputStream(Constant.PATH2);
        BufferedInputStream bis = new BufferedInputStream(is);//默认缓冲区 8192 是一个字节数组的长度
        BufferedOutputStream bos = new BufferedOutputStream(os);//默认缓冲区 8192 是一个字节数组的长度
        //使用流（输入流和输出流）
        int n = 0;
        n = bis.read();
        while (n != -1) {
            //写一个字节
            bos.write(n);
            //输出
            //System.out.println((char)n);
            //读一个字节
            n = bis.read();
        }

        //手动刷新（输出缓冲区内容写入文件），如果流没关闭，就需要手动刷新，
        // 因为输出流关闭的时候，也会先调用flush()方法
//        bos.flush();
        //关闭流（输入流和输出流）
        bis.close();
        bos.close();
//		is.close(); 不用再关闭，上面的关闭流会关闭底层包装的流
//		os.close();

    }
}

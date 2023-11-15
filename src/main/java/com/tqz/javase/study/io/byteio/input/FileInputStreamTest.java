package com.tqz.javase.study.io.byteio.input;

import com.tqz.javase.study.io.Constant;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 功能：复制文件的前一半：读取文件并输出
 *
 * <p>总结1：FileInputStream
 * 输入流  字节流  节点流
 *
 * <p>总结2：如何创建输入流对象
 * InputStream is = new FileInputStream(new File("d:/bjsxt.txt"));
 * InputStream is = new FileInputStream("d:/bjsxt.txt");
 *
 * <p>总结3：如何是输入流读文件
 * n = is.read();
 * 借助while和read()循环实现
 *
 * <p>总结4：如何关闭流
 * is.close();
 * 流不使用的时候一定要close();因为不仅是堆内存数据，还涉及和外存上文件的连接
 *
 * <p>总结5：缺点
 * 缺点1：不是不能够正确的读取汉字，是不能够正确的显示汉字
 * 缺点2：中转站只有一个字节，太小；影响效率
 *
 * @author tianqingzhao
 * @since 2023-05-23 20:37
 */
public class FileInputStreamTest {

    public static void main(String[] args) throws IOException {
        // 1.创建一个输入流
//		File file = new File("d:/bjsxt.txt");//a--97
//		InputStream  is = new FileInputStream(file);
        //InputStream is = new FileInputStream(new File("d:/bjsxt.txt"));
        InputStream is = new FileInputStream(Constant.PATH1);

        // 2.使用输入流读取文件并输出
        // 2.1创建一个中转站（水桶）
        int n;
        // 2.2读一个字节
        n = is.read(); // 读取一个字节
        while (n != -1) {
            // 2.3输出该字节
            System.out.print((byte) n);
            // 2.2读一个字节
            n = is.read(); // 从此输入流中读取一个数据字节
        }
        //3.关闭输入流，涉及和外存上文件的连接
        is.close();
    }

}

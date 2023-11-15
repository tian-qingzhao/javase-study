package com.tqz.javase.study.io.byteio.input;

import com.tqz.javase.study.io.Constant;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 功能：复制文件的前一半：读取文件并输出
 *
 * <p>缺点
 * 缺点1：不是不能够正确的读取汉字，是不能够正确的显示汉字
 * 缺点2：中转站只有一个字节，太小；影响效率
 * 解决：中转站采用一个字节数组，提高效率(现场展示效果)
 * 中文的显示没有真正的解决掉，但是不影响文件的复制
 * 中文的显示完全解决可以通过字符流来实现
 *
 * <p>总结1：
 * int len = is.read(buf); 读数据到buf，len是本次读取的字节数
 *
 * <p>总结2：字节数组和字符串之间的转换
 * 字节数组---->String
 * new String(buf, 0, len)
 * String----->字节数组
 * byte [] buf2 = str.getBytes();
 * byte [] buf2 = str.getBytes("utf-8");
 *
 * <p>缺点：没有进行异常处理
 *
 * @author tianqingzhao
 * @since 2023-05-23 21:02
 */
public class FileInputStreamTest2 {

    public static void main(String[] args) throws IOException {
        //1.创建一个输入流
        InputStream is = new FileInputStream(Constant.PATH1);

        //2.使用输入流读取文件并输出
        //2.1创建一个中转站（水桶）
        byte[] buf = new byte[10];
        //2.2读数据并输出

        //读取数据到buf
        int len = is.read(buf);//读数据到buf，len是本次读取的字节数
        while (len != -1) {
            //输出
            //System.out.println(len);
            //System.out.println(len+"  "+new String(buf));
            System.out.println(new String(buf, 0, len));
            //读取数据到buf
            len = is.read(buf);
        }
        //3.关闭输入流
        is.close();
    }
}

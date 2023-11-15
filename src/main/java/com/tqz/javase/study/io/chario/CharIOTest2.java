package com.tqz.javase.study.io.chario;

import com.tqz.javase.study.io.Constant;

import java.io.*;

/**
 * 功能：完成文件的复制（输出）
 * 技能：引入和使用字符流
 *
 * <p>问题：使用字节流读写文件没有问题，显示中文字符有问题
 * 解决：使用字符流
 *
 * <p>字节流：InputStream OutputStream
 * 字符流：Reader Writer
 *
 * <p>总结
 * 1.字节流每次读取一个字节，字符流每次读取1个字符
 * 英文字符是1个字节
 * 汉字字符是2个字节（GBK）,3个字节（UTF-8）
 * 2.字符流如何判断是英文还是汉字
 * 英文：1个字节的最高位是0
 * 汉字：2个字节，先读的字节最高位是1
 *
 * <p>3.使用字符流来复制文件，代码没有简化；
 * 但是显示汉字解决了乱码问题；
 * 和其他后续的字符流组合，可以简化代码
 *
 * <p>4.到底使用字节流还是字符流
 * FileReader---------InputStreamReader（字节流和字符流的转换流）--------Reader
 * 字符流的底层还是字节流
 * 字节流可以处理任何类型的文件；字符流只能处理文本文件
 * 对于文本文件，如果只是复制，而没有显示，还是使用字节流
 *
 * <p>缺点：没有进行异常处理
 *
 * @author tianqingzhao
 * @since 2023-05-24 19:59
 */
public class CharIOTest2 {

    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader(Constant.PATH1);
        Writer writer = new FileWriter(Constant.PATH2);

        char[] buf = new char[1024];

        int len = reader.read(buf);

        while (len != -1) {
            writer.write(buf, 0, len);

            System.out.println(new String(buf, 0, len));

            len = reader.read();
        }

        reader.close();
        writer.close();
    }
}

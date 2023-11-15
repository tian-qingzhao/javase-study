package com.tqz.javase.study.io.byteio.inputoutput;

import com.tqz.javase.study.io.Constant;

import java.io.*;

/**
 * 功能：复制文件的全部
 * 技能：FileInputStream和FileOutputStream
 *
 * <p>缺点：中转站太小了，只有一个字节，意味着大量的读写硬盘
 *
 * @author tianqingzhao
 * @since 2023-05-24 19:35
 */
public class CopyFileTest {

    public static void main(String[] args) throws IOException {
        //创建流（输入流和输出流）
        InputStream is = new FileInputStream(new File(Constant.PATH1));
        OutputStream os = new FileOutputStream(Constant.PATH2);

        //使用流（输入流和输出流）
        int n = 0;
        n = is.read();
        while (n != -1) {
            //写一个字节
            os.write(n);
            //输出
            System.out.println((char) n);
            //读一个字节
            n = is.read();
        }
        //关闭流（输入流和输出流）
        is.close();
        os.close();

    }
}

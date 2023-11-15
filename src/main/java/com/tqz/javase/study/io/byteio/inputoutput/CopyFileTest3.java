package com.tqz.javase.study.io.byteio.inputoutput;

import com.tqz.javase.study.io.Constant;

import java.io.*;

/**
 * 功能：复制文件的全部
 * 技能：FileInputStream和FileOutputStream
 *
 * <p>缺点：中转站太小了，只有一个字节，意味着大量的读写硬盘
 * 解决：中转站使用字节数组
 *
 * <p>结论1：使用字节数组做中转站，效率高
 * 结论2：使用字节流可以操作任何类型的文件（文本文件和二进制文件） doc是二进制文件
 *
 * <p>缺点：没有进行异常处理
 * 解决：进行异常处理
 * 注意：关闭两个流要分开处理，要判断是否为null
 *
 * @author tianqingzhao
 * @since 2023-05-24 19:40
 */
public class CopyFileTest3 {

    public static void main(String[] args) {
        InputStream is = null;
        OutputStream os = null;
        try {
            //创建流（输入流和输出流）
            is = new FileInputStream(Constant.PATH1);
            os = new FileOutputStream(Constant.PATH2);

            //使用流（输入流和输出流）
            byte[] buf = new byte[1024];
            int len = is.read(buf);
            while (len != -1) {
                //写一个字节数组
                //os.write(buf);//1024
                os.write(buf, 0, len);
                //读一个字节数组
                len = is.read(buf);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流（输入流和输出流）
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

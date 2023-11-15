package com.tqz.javase.study.io.byteio.output;

import com.tqz.javase.study.io.Constant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 功能：文件复制的后一半：写内容到文件中
 *
 * <p>总结1：如何创建输出流
 * OutputStream os = new FileOutputStream(file);替换
 * OutputStream os = new FileOutputStream(file, true);追加
 *
 * <p>总结2：输出流的方法
 * os.write(n);
 * os.close();
 *
 * <p>缺点：中转站太小了
 *
 * @author tianqingzhao
 * @since 2023-05-23 21:23
 */
public class FileOutputStreamTest {

    public static void main(String[] args) throws IOException {
        //指定内容
        String contents = "近日，北京尚学堂科技有限公司正式成为央视网广告合作伙伴，"
                + "为了践行企业诚信经营理念，进一步强化企业责任感和道德感，"
                + "打造行业标杆迈出了夯实的脚步";

        //创建一个输出流
        File file = new File(Constant.PATH1);
        //OutputStream os = new FileOutputStream(file);
        OutputStream os = new FileOutputStream(file, true);
        //使用输出流完成写操作
        //中转站使用一个字节
        int n;
        byte[] buf = contents.getBytes();
        for (int i = 0; i < buf.length; i++) {
            n = buf[i];
            os.write(n);
        }
        //关闭输出流
        os.close();
    }


}

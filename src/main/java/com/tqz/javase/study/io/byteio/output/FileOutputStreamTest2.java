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
 * 如果文件不存在，自动创建
 *
 * <p>总结2：输出流的方法
 * os.write(n);
 * os.write(buf);
 * os.close();
 *
 * <p>缺点：中转站太小了
 * 使用字节数组
 *
 * <p>缺点：没有进行异常处理
 *
 * @author tianqingzhao
 * @since 2023-05-23 21:24
 */
public class FileOutputStreamTest2 {

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
        //中转站使用一个字节数组
        byte[] buf = contents.getBytes();
        os.write(buf);
        //关闭输出流
        os.close();
    }
}

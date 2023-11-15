package com.tqz.javase.study.io.byteio.output;

import com.tqz.javase.study.io.Constant;

import java.io.*;

/**
 * 进行异常处理
 *
 * @author tianqingzhao
 * @since 2023-05-23 21:26
 */
public class FileOutputStreamTest3 {

    public static void main(String[] args) {
        //指定内容
        String contents = "近日，北京尚学堂科技有限公司正式成为央视网广告合作伙伴，"
                + "为了践行企业诚信经营理念，进一步强化企业责任感和道德感，"
                + "打造行业标杆迈出了夯实的脚步";

        //创建一个输出流
        File file = new File(Constant.PATH2);
        //OutputStream os = new FileOutputStream(file);
        OutputStream os = null;
        try {
            os = new FileOutputStream(file, true);
            //使用输出流完成写操作
            //中转站使用一个字节数组
            byte[] buf = contents.getBytes();
            os.write(buf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭输出流
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

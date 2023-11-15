package com.tqz.javase.study.io.chario;

import com.tqz.javase.study.io.Constant;

import java.io.*;

/**
 * 进行异常处理
 *
 * @author tianqingzhao
 * @since 2023-05-24 20:02
 */
public class CharIOTest3 {

    public static void main(String[] args) {
        Reader fr = null;
        Writer fw = null;
        try {
            //创建字符输入和输出流
            fr = new FileReader(Constant.PATH1);
            fw = new FileWriter(Constant.PATH2);
            //使用字符输入和输出流
            //中转站是一个字符
            char[] cbuf = new char[1024];
            int len = fr.read(cbuf);
            while (len != -1) {
                //写
                fw.write(cbuf, 0, len);
                //输出
                //System.out.println(new String(cbuf, 0, len));
                //读
                len = fr.read(cbuf);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭字符输入和输出流
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}

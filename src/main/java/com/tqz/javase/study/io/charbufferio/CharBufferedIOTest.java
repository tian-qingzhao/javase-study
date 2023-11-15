package com.tqz.javase.study.io.charbufferio;

import com.tqz.javase.study.io.Constant;

import java.io.*;

/**
 * 功能：完成文件的复制（输出）
 * 技能：引入和使用缓冲字符流
 *
 * @author tianqingzhao
 * @since 2023-05-24 21:18
 */
public class CharBufferedIOTest {

    public static void main(String[] args) throws IOException {
        //创建字符输入和输出流
        BufferedReader br = new BufferedReader(new FileReader(Constant.PATH1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(Constant.PATH2));
        //使用字符输入和输出流
        //中转站是一个字符
		/*
		int n;
		n = br.read();
		while(n != -1){
			//写
			bw.write(n);
			//输出
			//System.out.println(n+"---"+(char)n);
			//读
			n = br.read();
		}	*/

        // 中转站变大
        char[] cbuf = new char[1024];
        ;
        int len = br.read(cbuf);
        while (len != -1) {
            //写
            bw.write(cbuf, 0, len);
            //输出
            //System.out.println(n+"---"+(char)n);
            //读
            len = br.read(cbuf);
        }
        //关闭字符输入和输出流
        br.close();
        bw.close();
    }

}

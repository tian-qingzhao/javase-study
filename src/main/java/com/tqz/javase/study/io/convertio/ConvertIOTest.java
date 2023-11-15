package com.tqz.javase.study.io.convertio;

import com.tqz.javase.study.io.Constant;

import java.io.*;

/**
 * 功能：完成文件的复制（从键盘输入的一行行数据，写入文件）
 * 技能：引入和使用转换流
 *
 * <p>1.标准输入输出设备
 * System.in 输入设备  键盘
 * System.out  输出设备  显示器
 * System.err  错误信息输出设备  显示器
 *
 * <p>2.System.in是字节流，readLine只有字符流提供，怎么办？
 * 三相的插头  ------- （三相插座）转换头 （两相插头）  ------ 二相的插座
 * 字节流InputStream----- 转换流InputStreamReader    ------  字符流Reader
 * 进去的是字节流，返回的是字符流
 *
 * <p>3.转换流
 * InputStream is= System.in;
 * Reader reader = new InputStreamReader(is);
 * BufferedReader br = new BufferedReader(reader);
 * public class InputStreamReader extends Reader
 *
 * <p>4.转换流有几个
 * InputStreamReader   InputStream------>Reader
 * OutputStreamWriter  OutputStream------>Writer
 * ReaderInputStream   没有
 * WriterOutputStream   没有
 * 字节流可以转换字符流，字符流没有必要转换成字节流
 *
 * @author tianqingzhao
 * @since 2023-05-26 20:30
 */
public class ConvertIOTest {

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Constant.PATH1));

        int n = 0;
        String str = bufferedReader.readLine();
        while (!"exit".equals(str)) {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            str = bufferedReader.readLine();
        }

        bufferedReader.close();
        bufferedWriter.close();

    }
}

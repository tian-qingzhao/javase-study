package com.tqz.javase.study.io.convertio;

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
 * <p>5.FileReader----------InputStreamReader（将字节流成字符流）
 * 字符流的底层还是字节流
 *
 * <p>6.缺点：使用流接收键盘的输入太复杂了,高版本中提供了Scanner
 * 使用流输出内容到显示器太复杂了，还是使用System.out.println(str);好
 * System.out ----PrintStream
 *
 * @author tianqingzhao
 * @since 2023-05-26 20:54
 */
public class ConvertIOTest2 {

    public static void main(String[] args) throws IOException {
        System.out.println("123");
        PrintStream out = System.out;
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(out));

        String str = bufferedReader.readLine();
        while (!"exit".equals(str)) {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            str = bufferedReader.readLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}

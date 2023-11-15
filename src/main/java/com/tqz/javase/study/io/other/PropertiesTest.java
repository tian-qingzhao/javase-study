package com.tqz.javase.study.io.other;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 1.认识Properties类
 * public class Properties extends Hashtable
 * 是一个Map的实现类，可以保存键值对
 * key-value都是String
 * 一般是和属性文件结合使用
 * 属性文件: 保存是配置信息，格式username=bjsxt
 * 2.使用Properties类写属性文件
 * OutputStream os = new FileOutputStream("conn.properties");
 * prop.store(os, "user information");
 * 3.使用Properties类读属性文件
 * InputStream is = new FileInputStream("conn.properties");
 * prop.load(is);
 *
 * @author tianqingzhao
 * @since 2023-05-27 17:00
 */
public class PropertiesTest {

    final static String PATH = "D:\\idea_workspace\\javaSE-study\\src\\main\\java\\com\\tqz\\javase\\study\\" +
            "io\\other\\conn.properties";

    public static void main(String[] args) throws IOException {
        // 写properties到文件里面
//        write();

        Properties properties = new Properties();

        FileInputStream fileInputStream = new FileInputStream(PATH);
        properties.load(fileInputStream);

        System.out.println(properties);

        String usernameKey = "username";
        String usernameValue = properties.getProperty(usernameKey);
        if (usernameValue != null) {
            properties.setProperty(usernameKey, "tianqingzhao");
        }

        FileOutputStream fileOutputStream = new FileOutputStream(PATH);
        properties.store(fileOutputStream, "test properties");
        fileOutputStream.close();
    }

    private static void write() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(PATH);

        Properties properties = new Properties();
        properties.setProperty("username", "root");
        properties.setProperty("password", "123456");

        properties.store(fileOutputStream, "test properties");

        fileOutputStream.close();
    }

}

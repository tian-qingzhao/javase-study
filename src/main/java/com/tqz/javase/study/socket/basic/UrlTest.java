package com.tqz.javase.study.socket.basic;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author tianqingzhao
 * @since 2023-05-11 19:19
 */
public class UrlTest {

    public static void main(String[] args) throws MalformedURLException {
        URL u = new URL("ftp://www.baidu.cn:8090/xx/yy/zz/index.html#aa?username=bjsxt&pwd=bjsxt");

        System.out.println("协议："+u.getProtocol());
        System.out.println("主机名："+u.getHost());  //www.google.cn
        System.out.println("端口："+u.getPort());  //存在返回80.否则返回-1
        System.out.println("获取与此url关联的协议的默认端口："+u.getDefaultPort());
        System.out.println("路径："+u.getPath());  //端口号后，参数前的内容
        System.out.println("getFile:"+u.getFile());  //端口号后面的内容
        System.out.println("参数部分："+u.getQuery());
        System.out.println("锚点："+u.getRef()); //

        URL u2 = new URL("http://www.abc.com/aa/");
        URL u3 = new URL(u2,"/sdf/sdfsd/sdfs/2.html");  //相对路径构建url对象
        System.out.println(u3.toString());
    }
}

package com.tqz.javase.study.collections.other;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Hashtable :线程安全   synchronized，底层也是hash表。
 * Hashtable 从JDK1.0版本就有了，ArrayList 是JDK1.2开始提供的
 *
 * @author tianqingzhao
 * @since 2023-05-14 17:20
 */
public class HashTableTest {

    public static void main(String[] args) {
        //创建Hashtable对象
        Hashtable<String, String> ht = new Hashtable<>();

        //添加键值对
        ht.put("cn", "China");
        ht.put("jp", "Japan");
        ht.put("us", "America");
        ht.put("us", "the United States");

        //遍历所有的key
        Enumeration<String> en = ht.keys();
        while (en.hasMoreElements()) {
            String key = (String) en.nextElement();
            System.out.println(key + "------>" + ht.get(key));
        }
        //遍历所有的value
        Enumeration<String> en2 = ht.elements();
        while (en2.hasMoreElements()) {
            String value = (String) en2.nextElement();
            System.out.println(value);
        }
        ht.keySet();
        ht.values();

    }
}

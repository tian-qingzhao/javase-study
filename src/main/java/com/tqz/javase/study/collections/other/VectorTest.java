package com.tqz.javase.study.collections.other;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * Vector :线程安全   synchronized
 * Vector从JDK1.0版本就有了，ArrayList是JDK1.2开始提供的。
 *
 * @author tianqingzhao
 * @since 2023-05-14 17:19
 */
public class VectorTest {

    public static void main(String[] args) {
        //创建Vector对象
        Vector<String> vector = new Vector<>();
        //添加多个元素
        vector.addElement("Java");
        vector.addElement("Oracle");
        vector.addElement("HTML");
        vector.addElement("Java");
        vector.add("CSS");

        //遍历集合
        Enumeration<String> en = vector.elements();
        while (en.hasMoreElements()) {
            //取
            Object elem = en.nextElement();
            //输
            System.out.println(elem);
        }

        Iterator<String> it = vector.iterator();

        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.remove(1);

    }
}

package com.tqz.javase.study.collections.arraylist;

import java.util.ArrayList;

/**
 * 功能：使用集合存储多个学生的分数
 * 技能：引入和使用集合
 * 分析：学生的分数可能重复，有先后顺序，使用列表List合适
 * 总结1：List的特点
 * 不唯一  有序 （索引顺序）
 *
 * <p>总结2：List的方法
 * list.add(56);//添加元素到集合的最后一个元素位置
 * list.add(0, 67);//操作很简单，底层大量的移动元素
 * list.addAll(list2);
 * list.addAll(2, list2);
 * list.size()：是元素的个数，不是底层数组分配空间的多少length
 *
 * <p>注意：集合中只能存储Object引用数据类型，不能存储基本数据类型
 * JDK1.5之后，提供了自动装箱功能，可以将基本数据类型（自动包装成包装类对象后）的放入
 *
 * @author tianqingzhao
 * @since 2023-05-13 10:44
 */
public class ArrayListTest1 {

    public static void main(String[] args) {
        // 创建一个List对象来存储分数
        // ArrayList list = new ArrayList();//底层是长度可变的数组，默认大小10
        ArrayList list = new ArrayList(2); // 底层是长度可变的数组，默认大小10
        // 向List对象中添加分数
        list.add(56);// 添加元素到集合的最后一个元素位置
        //list.add(new Integer(56));
        list.add(78);
        list.add(100);
        //list.add(67);
        list.add(0, 67); // 操作很简单，底层大量的移动元素

        ArrayList list2 = new ArrayList();
        list2.add(98);
        list2.add(34);
        list2.add(89);
        list2.add(34);

        //list.addAll(list2);
        list.addAll(2, list2);
        // 输出所有的分数
        System.out.println(list.size());
        System.out.println(list.toString()); // toString已经重写
        System.out.println(list2);
    }
}

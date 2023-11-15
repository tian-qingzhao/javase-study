package com.tqz.javase.study.collections.arraylist;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 功能：使用集合存储多个学生的分数
 * 技能：ArrayList的其他方法
 *
 * <p>1.添加
 * list.add(56);
 * list.add(0, 67);
 * list.addAll(..)
 *
 * <p>2.删除
 * list.remove(new Integer(78));
 * list.remove(0);
 * list.removeAll()
 * list.clear()
 *
 * <p>3.修改
 * list.set(0, 65);
 *
 * <p>4.其他
 * list.isEmpty()
 * list.contains(65)
 * list.ensureCapacity(1000);
 * list.indexOf(100)
 * list.toArray();
 * list.toArray(new Integer[list.size()]);
 *
 * <p>总结1：List和Collection区别
 * Collection 无序
 * List 索引有序
 * List接口相比Collection接口，增加了与索引操作相关的方法
 *
 * @author tianqingzhao
 * @since 2023-05-13 11:01
 */
public class ArrayListTest4 {

    public static void main(String[] args) {
        //创建一个List对象来存储分数
        //ArrayList list = new ArrayList();//底层是长度可变的数组，默认大小10
        ArrayList<Integer> list = new ArrayList<Integer>(2);//底层是长度可变的数组，默认大小10
        //向List对象中添加分数
        list.add(56);//添加元素到集合的最后一个元素位置
        //list.add(new Integer(56));
        list.add(78);
        list.add(100);
        list.add(0, 67);//操作很简单，底层大量的移动元素
        //输出所有的分数
        System.out.println(list.size());
        System.out.println(list.toString());//toString已经重写
//		list.remove(new Integer(78));
//		list.remove(0);
        //list.removeAll()
        //list.clear();

        list.set(0, 65);
        //list.clear();
        //list.toArray(a);
        //list.ensureCapacity(1000);
        System.out.println(list.indexOf(100));
        ;
        System.out.println(list.contains(65));
        System.out.println(list.isEmpty());
        System.out.println(list.toString());//toString已经重写

        Object[] arr = list.toArray();
        //Integer [] arr2 = list.toArray(new Integer[10]);
        Integer[] arr2 = list.toArray(new Integer[list.size()]);
        System.out.println(Arrays.toString(arr2));
    }
}

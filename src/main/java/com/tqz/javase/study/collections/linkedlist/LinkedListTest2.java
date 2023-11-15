package com.tqz.javase.study.collections.linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * 功能：使用集合存储多个学生的分数
 * 技能：面向接口编程
 *
 * <p>建议
 * List<Integer> list = new LinkedList<Integer>();
 * 不推荐
 * LinkedList<Integer> list = new LinkedList<Integer>();
 * 便于重用代码，减少修改量
 *
 * @author tianqingzhao
 * @since 2023-05-13 11:10
 */
public class LinkedListTest2 {

    public static void main(String[] args) {
        //创建一个List对象来存储分数
        //ArrayList<Integer> list = new ArrayList<Integer>();//底层是长度可变的数组，默认大小10
        //LinkedList<Integer> list = new LinkedList<Integer>();
        //List<Integer> list = new ArrayList<Integer>();
        List<Integer> list = new LinkedList<Integer>();

        //向List对象中添加分数
        method(list);
//		list.getFirst();
//		list.getLast();
//		list.removeFirst();
//		list.removeLast()
    }

    /**
     * 多态
     * 最主要的应用的场合，使用父类/接口做方法的形参
     * 实参可以是该父类或者接口的任意子类类型
     *
     * @param list
     */
    public static void method(List<Integer> list) {
        list.add(56);//添加元素到集合的最后一个元素位置
        list.add(78);
        list.add(100);
        list.add(0, 67);//操作很简单，底层大量的移动元素
        System.out.println(list.toString());//toString已经重写
        //输出所有的分数

        list.remove(new Integer(78));
        list.remove(0);
        System.out.println(list.toString());//toString已经重写

        //list.addFirst(45);
        list.add(0, 45);
        list.add(0, 45);
        //list.addLast(67);
        list.add(67);
    }
}

package com.tqz.javase.study.collections.linkedlist;

import java.util.LinkedList;

/**
 * 功能：使用集合存储多个学生的分数
 * 技能：LinkedList
 *
 * <p>之前:ArrayList<Integer> list = new ArrayList<Integer>();
 * 现在：LinkedList<Integer> list = new LinkedList<Integer>();
 *
 * <p>不变的是：
 * 输出结果没有变
 * 后续代码没有变
 *
 * <p>变化的是：
 * 底层的存储结构：之前是顺序表，现在是链表
 * 操作过程：链表的添加/删除只要修改指向即可，顺序的添加/删除需要大量的移动元素
 * 执行效率：对于添加和删除操作，链表的效率高
 *
 * <p>LinkedList增加的方法：
 * list.addFirst(e);
 * list.addLast(e);
 * list.getFirst();
 * list.getLast();
 * list.removeFirst();
 * list.removeLast()
 *
 * @author tianqingzhao
 * @since 2023-05-13 11:09
 */
public class LinkedListTest1 {

    public static void main(String[] args) {
        //创建一个List对象来存储分数
        //ArrayList<Integer> list = new ArrayList<Integer>();//底层是长度可变的数组，默认大小10
        LinkedList<Integer> list = new LinkedList<Integer>();
        //向List对象中添加分数
        list.add(56);//添加元素到集合的最后一个元素位置
        list.add(78);
        list.add(100);
        list.add(0, 67);//操作很简单，底层大量的移动元素
        System.out.println(list);//toString已经重写
        //输出所有的分数

        list.remove(new Integer(78));
        list.remove(0);
        System.out.println(list.toString());//toString已经重写

        list.addFirst(45);
        list.add(0, 45);
        list.addLast(67);
        list.add(67);
//		list.getFirst();
//		list.getLast();
//		list.removeFirst();
//		list.removeLast()
    }
}

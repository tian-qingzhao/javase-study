package com.tqz.javase.study.collections.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 功能：使用集合存储多个学生的分数
 * 技能：遍历集合
 *
 * <p>总结：1.遍历List集合
 * 遍历1：使用for循环
 * 遍历2：使用增强的for循环 for-each
 * 遍历3：采用迭代器Iterator遍历
 *
 * <p>总结2：
 * list.get(i)
 * Iterator it = list.iterator();
 * it.hasNext()
 * it.next()
 * Iterator就是专门用来遍历集合的
 *
 * @author tianqingzhao
 * @since 2023-05-13 10:45
 */
public class ArrayListTest2 {

    public static void main(String[] args) {
        // 创建一个List对象来存储分数
        // ArrayList list = new ArrayList();//底层是长度可变的数组，默认大小10
        ArrayList list = new ArrayList(2);//底层是长度可变的数组，默认大小10
        //向List对象中添加分数
        list.add(56);//添加元素到集合的最后一个元素位置
        //list.add(new Integer(56));
        list.add(78);
        list.add(100);
        //list.add(67);
        list.add(0, 67);//操作很简单，底层大量的移动元素
        //输出所有的分数
        System.out.println(list.size());
        System.out.println(list.toString());//toString已经重写

        //遍历1：使用for循环
        for (int i = 0; i < list.size(); i++) {
            //获取第i个元素
            Object elem = list.get(i);
            //输出第i个元素
            System.out.println((i + 1) + "   " + elem);
        }

        //遍历2：使用增强的for循环 for-each
        //int i=0;
        for (Object elem : list) {
            System.out.println(elem);
        }
        //遍历3：采用迭代器Iterator遍历
        Iterator it = list.iterator();
        while (it.hasNext()) {
            //取出元素
            //Object elem = it.next();
            int elem = (int) it.next();
            //输出元素
            System.out.println(elem);
        }

    }
}

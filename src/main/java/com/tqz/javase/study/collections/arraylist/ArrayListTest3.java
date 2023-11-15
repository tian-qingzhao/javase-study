package com.tqz.javase.study.collections.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 功能：使用集合存储多个学生的分数
 * 技能：引入和使用泛型
 *
 * <p>缺点1：不安全----list.add(78);参数是Object类型，所以可以list.add("sxt");-
 * 缺点2：繁琐----list.get(i);int elem=(int)it.next();需要强制转换
 * 缺点3： 黄色的警告
 *
 * <p>解决：泛型
 *
 * <p>泛型的好处
 * 1.安全
 * 2.不繁琐 简单
 *
 * <p>泛型要求会使用即可，并不要求定义泛型
 *
 * @author tianqingzhao
 * @since 2023-05-13 11:00
 */
public class ArrayListTest3 {

    public static void main(String[] args) {
        //创建一个List对象来存储分数
        //ArrayList list = new ArrayList();//底层是长度可变的数组，默认大小10
        ArrayList<Integer> list = new ArrayList<Integer>(2);//底层是长度可变的数组，默认大小10
        //向List对象中添加分数
        list.add(56);//添加元素到集合的最后一个元素位置
        //list.add(new Integer(56));
        list.add(78);
        list.add(100);
        //list.add("sxt");
        //list.add("sxt");
        //list.add(67);
        list.add(0, 67);//操作很简单，底层大量的移动元素
        //输出所有的分数
        System.out.println(list.size());
        System.out.println(list.toString());//toString已经重写

        //遍历1：使用for循环
        for (int i = 0; i < list.size(); i++) {
            //获取第i个元素
            int elem = list.get(i);
            //输出第i个元素
            System.out.println((i + 1) + "   " + elem);
        }

        //遍历2：使用增强的for循环 for-each
        //int i=0;
        for (int elem : list) {
            System.out.println(elem);
        }
        //遍历3：采用迭代器Iterator遍历
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            //取出元素
            //Object elem = it.next();
            int elem = it.next();
            //输出元素
            System.out.println(elem * 1.2);
        }

    }

}

package com.tqz.javase.study.collections.set;

import java.util.Set;
import java.util.TreeSet;

/**
 * 功能：使用set存储多个学生的信息
 * 技能：set
 *
 * <p>问题1:使用TreeSet可以实现String类型数据的自然排序，但是不能实现Student类型数据的排序
 * java.lang.ClassCastException: cn.sxt.container.set.Student
 * cannot be cast to java.lang.Comparable
 * 原因：String是系统类，已经实现了Comparable接口，Student类也需要实现该接口才可以
 *
 * <p>问题2：为什么实现了该接口，就可以保证元素的有序
 * 原因：TreeSet的原理：底层采用的二叉树（红黑树）
 *
 * <p>问题3：Student类实现了Comparable，只能指定一种比较和排序的规则。如果希望得到多种排序规则的结果，怎么办？
 * Comparable：内部比较器  只有一个规则最常用的规则（学生按照id）
 *
 * @author tianqingzhao
 * @since 2023-05-13 20:40
 */
public class TreeSetTest3 {

    public static void main(String[] args) {
        //创建一个set集合对象
        Set<Student> stuset = new TreeSet<>();
        //向集合对象中添加学生信息
        stuset.add(new Student(3, "大刚", 20, 90.8));
        stuset.add(new Student(4, "夏明明", 23, 90.6));
        stuset.add(new Student(1, "夏明", 20, 90.3));
        stuset.add(new Student(2, "小芳", 18, 90.5));
        stuset.add(new Student(1, "夏明", 20, 90));
        stuset.add(new Student(1, "夏明", 20, 90));

        //stuset.remove(new Student(1, "夏明", 20, 90));
        //输出集合的size和元素
        System.out.println(stuset.size());
        System.out.println(stuset);
        //Student stu;
        //stu.equals(null);
    }
}

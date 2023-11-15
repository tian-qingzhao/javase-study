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
 * Comparator ：外部比较器  可以定义多个比较器，指定多个规则
 * 按照score排序 ，
 * 按照age排序
 * 按照score和age排序（score相同，再比较age）
 *
 * @author tianqingzhao
 * @since 2023-05-13 21:11
 */
public class TreeSetTest4 {

    public static void main(String[] args) {
        // 按照id
        //创建一个set集合对象
        Set<Student> stuset = new TreeSet<Student>();
        //向集合对象中添加学生信息
        stuset.add(new Student(3, "大刚", 20, 90.8));
        stuset.add(new Student(4, "夏明明", 23, 90.6));
        stuset.add(new Student(1, "夏明", 20, 90.3));
        stuset.add(new Student(2, "小芳", 18, 90.5));
        stuset.add(new Student(1, "夏明", 20, 90));
        stuset.add(new Student(1, "夏明", 20, 90));
        System.out.println(stuset.size());
        System.out.println(stuset);

        System.out.println("按照分数比较");
        // 外部比较器优先于内部比较器，也就是Comparator接口优先于Comparable
        StuScoreComparator sscr = new StuScoreComparator();
        Set<Student> stuset2 = new TreeSet<Student>(sscr);
        stuset2.add(new Student(3, "大刚", 20, 90.8));
        stuset2.add(new Student(4, "夏明明", 23, 90.6));
        stuset2.add(new Student(1, "夏明", 20, 90.3));
        stuset2.add(new Student(2, "小芳", 18, 90.5));
        stuset2.add(new Student(1, "夏明", 20, 90));
        stuset2.add(new Student(1, "夏明", 20, 90));
        System.out.println(stuset2.size());
        System.out.println(stuset2);

        System.out.println("按照姓名比较，姓名一样按照id排序");
        //StuNameDescComparator sndcr = new StuNameDescComparator();
        //Set<Student> stuset3  = new TreeSet<Student>(sndcr);
        // 使用匿名内部类
        Set<Student> stuset3 = new TreeSet<>((stu1, stu2) -> {
            int result = stu1.getName().compareTo(stu2.getName());
            if (result != 0) {
                return result;
            } else {
                return stu1.getId() - stu2.getId();
            }
        });
        //向集合对象中添加学生信息
        stuset3.add(new Student(3, "aaa", 20, 90.8));
        stuset3.add(new Student(4, "bbbb", 23, 90.6));
        stuset3.add(new Student(1, "dddd", 20, 90.3));
        stuset3.add(new Student(2, "cccc", 18, 90.5));
        stuset3.add(new Student(1, "aaa", 20, 90));
        stuset3.add(new Student(1, "aaa", 20, 90));
        System.out.println(stuset3.size());
        System.out.println(stuset3);

    }
}

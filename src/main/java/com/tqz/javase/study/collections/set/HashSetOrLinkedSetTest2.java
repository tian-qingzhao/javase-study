package com.tqz.javase.study.collections.set;

import java.util.HashSet;
import java.util.Set;

/**
 * 功能：使用set存储多个学生的信息
 * 技能：set
 *
 * <p>缺点1：使用HashSet存储多个字符串（课程名称），可以保证唯一性；但是HashSet存储多个学生对象，不可以保证唯一性
 * 判断是否唯一的依据：equals() 而不是 ==
 * 原因：String是系统类，已经重写了equals();Student 是自定义类，还没有重写equals()；
 * 解决：重写equals
 *
 * <p>缺点2：重写了equals也不行
 * 原因：涉及哈希表的原理，不仅要重写equals(),还要重写hashCode()
 *
 * <p>问题1：hashCode和equals到底有什么神奇的作用
 * 问题2：哈希表的工作原理
 *
 * <p>1.哈希表的结构和特点
 * 特点：快   很快  神奇的快
 * 结构：结构有多种
 * 最流行、最容易理解：顺序表+链表
 * 主结构：顺序表
 * 每个顺序表的节点在单独引出一个链表
 *
 * <p>2.哈希表是如何添加数据的
 * 1.计算哈希码(调用hashCode(),结果是一个int值，整数的哈希码取自身即可)
 * 2.计算在哈希表中的存储位置  y=k(x)=x%11 x:哈希码  k(x) 函数    y：在哈希表中的存储位置
 * 3.存入哈希表
 * 情况1：一次添加成功
 * 情况2：多次添加成功（出现了冲突，调用equals()和对应链表的元素进行比较，
 * 比较到最后，结果都是false，创建新节点，存储数据，并加入链表末尾）
 * 情况3：不添加（出现了冲突，调用equals()和对应链表的元素进行比较，
 * 经过一次或者多次比较后，结果是true，表明重复，不添加）
 * 结论1：哈希表添加数据快（3步即可，不考虑冲突）
 * 结论2：唯一
 * 结论2：无序
 *
 * <p>4.hashCode和equals到底有什么神奇的作用
 * hashCode():计算哈希码，是一个整数，根据哈希码可以计算出数据在哈希表中的存储位置
 * equals()：添加时出现了冲突，需要通过equals进行比较，判断是否相同
 * 查询时也需要使用equals进行比较，判断是否相同
 *
 * <p>5.各种类型数据的哈希码应该如何获取
 * 1.int   取自身 看Integer的源码
 * 2.double  3.14 3.15  3.145  6.567  9.87  取整不可以  看Double的源码
 * 3.String java  oracle  j+a+v+a  将各个字符的编码值相加不可以
 * abc cba  bac  a:97  b:98  c:99
 * abc 1*97+2*98+3*99
 * cba 1*99+2*98+3*97
 * 4.Student 先各个属性的哈希码，进行某些相加相乘的运算
 * int id
 * String name
 * int age
 * double score;
 *
 * @author tianqingzhao
 * @since 2023-05-13 20:22
 */
public class HashSetOrLinkedSetTest2 {

    public static void main(String[] args) {
        Integer in;
        Double d;
        String str;
        //创建一个set集合对象
        Set<Student> stuset = new HashSet<>();
        //Set<Student> stuset  = new LinkedHashSet<Student>();
        //向集合对象中添加学生信息
        stuset.add(new Student(3, "王五", 20, 87));
        stuset.add(new Student(4, "赵六", 23, 100));
        stuset.add(new Student(1, "张三", 20, 90));
        stuset.add(new Student(2, "李四", 18, 98));

        // 如果不重写hashCode和equals方法，set里面会有6个元素，尽管下面两个和第三个是一样的。
        stuset.add(new Student(1, "张三", 20, 90));
        stuset.add(new Student(1, "张三", 20, 90));

        //输出集合的size和元素
        System.out.println(stuset.size());
        System.out.println(stuset);
    }

}

package com.tqz.javase.study.collections.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 功能：使用Set存储多个学生的分数  不合理
 * 功能：使用Set存储课程的名称 合理
 *
 * <p>总结1：set的特点
 * HashSet  唯一   无序
 * LinkedHashSet 唯一 有序（添加顺序）
 * TreeSet  唯一  有序（自然顺序）
 *
 * <p>总结2：
 * Collection的两个子接口List和Set
 * Collection
 * Set：相比Collection，没有增加任何的方法
 * List：相比Collection，增加了和索引相关（索引顺序）的方法
 *
 * <p>总结3：遍历方式
 * 1.使用for-each遍历
 * 2.使用Iterator遍历
 * 注意：不能使用for遍历，因为没有get(index)
 *
 * @author tianqingzhao
 * @since 2023-05-13 20:11
 */
public class SetTest1 {

    public static void main(String[] args) {
        //创建一个set集合
        //HashSet<String> set = new HashSet<String>(); // 无序
        //Set<String> set = new LinkedHashSet<String>(); // 有序，添加顺序
        Set<String> set = new TreeSet<String>(); // 有序，自然顺序，需要实现Comparator接口，String/Integer已经实现了该接口
        //添加课程
        set.add("Java");
        set.add("HTML");
        set.add("Oracle");


        set.add("Java");
        //输出课程数量及其名称
        System.out.println(set.size());//3
        System.out.println(set.toString());//

        //遍历1
//		for(int i=0;i<set.size();i++){
//			set.get(i);//set是无序的，没有索引
//		}
        //遍历2
        for (String elem : set) {
            System.out.println(elem);
        }

        //遍历3
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            //取出
            String elem = it.next();
            //输出
            System.out.println(elem);
        }
    }
}

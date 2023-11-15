package com.tqz.javase.study.collections.other;

import java.util.*;

/**
 * {@link Iterator} 学习
 *
 * <p>1.Iterator专门为遍历集合而生，集合并没有提供专门的遍历的方法
 *
 * <p>2.Iterator实际上迭代器设计模式的实现
 *
 * <p>3.方法
 * boolean hasNext();
 * E next()
 * void remove()
 * ConcurrentModificationException
 *
 * <p>4.哪些集合可以使用Iterator遍历
 * Collection：可以
 * List:可以
 * Set：可以
 * Map:不可以 *
 * 提供iterator()方法的就可以将元素交给Iterator;
 * 实现Iterable的集合类都可以使用迭代器遍历
 *
 * <p>5.增强的for循环和Iterator的联系
 * 增强的for循环(遍历集合)时，底层使用的是Iterator
 * 凡是可以使用增强的for循环(遍历的集合)，肯定也可以使用Iterator进行遍历
 *
 * <p>6.增强的for循环和Iterator的区别
 * 1.for-each还能遍历数组，Iterator只能遍历集合
 * 2.使用for-each遍历集合时不能删除元素，使用Iterator遍历合时能删除元素，
 *
 * <p>7.Iterator是一个接口，它的实现类在哪里？
 * 在相应的集合实现类中
 * 问题：为什么Iterator不设计成一个类，而是一个接口
 * 不同的集合类，底层结构不同，迭代的方式不同，所以提供一个接口，让相应的实现类来实现
 *
 * @author tianqingzhao
 * @since 2023-05-14 16:57
 */
public class IteratorTest {

    public static void main(String[] args) {
        //创建一个集合对象
        List<Integer> list = new ArrayList<Integer>();//

        //向集合中添加分数
        list.add(78);
        list.add(80);
        list.add(89);

        Set set = new HashSet();
        set.iterator();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer elem = it.next();
            if (elem < 79) {
                //list.remove(new Integer(78));
                //list.add(89);
                it.remove();
            }
            System.out.println(elem);
        }

        for (Integer elem : list) {
            System.out.println(elem);
//			if(elem < 79 ){
//				list.remove(new Integer(78));
//			}
        }
    }
}

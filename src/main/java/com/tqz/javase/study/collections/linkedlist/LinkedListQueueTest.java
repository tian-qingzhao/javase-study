package com.tqz.javase.study.collections.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 功能：模拟生活中超市购物排队结算
 * 技能：使用LinkedList实现队列的操作
 *
 * @author tianqingzhao
 * @since 2023-05-13 19:11
 */
public class LinkedListQueueTest {

    public static void main(String[] args) {
        //创建一个队列
        Queue<String> queue = new LinkedList<>();
        //入队
        queue.add("张三");
        queue.add("李四");
        queue.add("王五");
        //获取队头元素
        System.out.println(queue.element()); // 没有元素抛异常
        System.out.println(queue.element());
        System.out.println(queue.element());
        System.out.println(queue.peek()); // 没有元素返回null
        //出队
        System.out.println(queue.remove()); // 没有元素抛异常
        System.out.println(queue.poll()); // 没有元素返回null
        queue.add("赵六");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }
}

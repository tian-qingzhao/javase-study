package com.tqz.javase.study.collections.linkedlist;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 功能：模拟生活中罗盘子案例
 * 技能：LinkedList
 *
 * <p>LinkedList既可以当做线性表处理，也可以当做栈、队列使用
 *
 * @author tianqingzhao
 * @since 2023-05-13 19:10
 */
public class LinkedListDequeTest {

    public static void main(String[] args) {
        //创建一个栈
        Deque<String> deque = new LinkedList<>();
        //罗盘子:入栈
//		deque.addFirst("盘子1");
//		deque.addFirst("盘子2");
//		deque.addFirst("盘子3");
        deque.push("盘子1");
        deque.push("盘子2");
        deque.push("盘子3");
        //获取最上面的盘子：获取栈顶元素
//		System.out.println(deque.getFirst());
//		System.out.println(deque.getFirst());
//		System.out.println(deque.getFirst());
        System.out.println(deque.peek());
        System.out.println(deque.peek());
        System.out.println(deque.peek());
        //拿走盘子：出栈
//		System.out.println(deque.removeFirst());
//		System.out.println(deque.removeFirst());
//		System.out.println(deque.removeFirst());
        System.out.println(deque.pop());
        System.out.println(deque.pop());
        System.out.println(deque.pop());
    }
}

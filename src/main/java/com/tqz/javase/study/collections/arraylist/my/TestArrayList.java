package com.tqz.javase.study.collections.arraylist.my;

/**
 * 测试手动实现的ArrayList
 *
 * @author tianqingzhao
 * @since 2023-05-13 19:36
 */
public class TestArrayList {

    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 200; i++) {
            list.add("elem" + i);
        }
        System.out.println(list);
    }

}

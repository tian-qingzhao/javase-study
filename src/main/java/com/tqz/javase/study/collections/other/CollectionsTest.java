package com.tqz.javase.study.collections.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author tianqingzhao
 * @since 2023-05-14 18:25
 */
public class CollectionsTest {

    public static void main(String[] args) {
        //创建一个集合
        List<Integer> list = new ArrayList<Integer>();
        //一次添加多个元素
        Collections.addAll(list, 30, 40, 60, 50, 78, 67);
        System.out.println(list);
        //排序
        Collections.sort(list);
        System.out.println(list);
        //查询:二分法查询，要求集合必须是有序的
        int index = Collections.binarySearch(list, 67);
        System.out.println(index);

        //获取最大值和最小值
        int max = Collections.max(list);
        int min = Collections.min(list);
        System.out.println(max + "   " + min);

        //填充操作
        //Collections.fill(list, 0);
        System.out.println(list);

        //复制
        List<Integer> list2 = new ArrayList<>();
        Collections.addAll(list2, 100, 123, 456, 789, 543, 456, 333, 123);
        System.out.println(list2);
        Collections.copy(list2, list);//source  destination
        System.out.println(list2);
        System.out.println(list);

        //ArrayList是线程非安全的，在多线程下，程序员自己通过代码实现线程同步，保证安全
        List<Integer> list3 = new ArrayList<Integer>();
        Collections.addAll(list3, 3, 4, 6, 5, 7, 6);
        System.out.println(list3);
        List<Integer> list4 = Collections.synchronizedList(list3);
        list4.add(12);
        list4.remove(2);
    }
}

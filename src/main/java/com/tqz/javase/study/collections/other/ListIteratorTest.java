package com.tqz.javase.study.collections.other;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * <p>一、ListIterator和Iterator的关系
 * 1.public interface ListIterator<E> extends Iterator<E>
 * 2.都可以遍历List
 *
 * <p>二、ListIterator和Iterator的区别
 * 1.使用范围不同
 * Iterator可以应用于更多的集合，Set、List和这些集合的子类型。
 * 而ListIterator只能用于List及其子类型。
 * 2.遍历顺序不同
 * Iterator只能顺序向后遍历
 * ListIterator还可以逆序向前遍历
 * 3.Iterator可以在遍历的过程中remove()
 * ListIterator可以在遍历的过程中remove()、add()、set()
 * 4.ListIterator可以定位当前的索引位置，nextIndex()和previousIndex()可以实现。
 * Iterator没有此功能。
 *
 * @author tianqingzhao
 * @since 2023-05-14 16:59
 */
public class ListIteratorTest {

    public static void main(String[] args) {
        //创建一个集合对象
        List<Integer> list = new ArrayList<Integer>();//

        //向集合中添加分数
        list.add(78);
        list.add(80);
        list.add(89);

        ListIterator<Integer> lit = list.listIterator();
        //从前向后

        while (lit.hasNext()) {
            //取出来
            Integer elem = lit.next();
            //查看索引
            //System.out.println(lit.previousIndex()+"  "+lit.nextIndex());
            //输出去
            System.out.println(elem);
        }

        //从后向前，必须先从前向后
        while (lit.hasPrevious()) {
            //取出来
            Integer elem = lit.previous();
            //输出去
            System.out.println(elem);
        }
    }
}

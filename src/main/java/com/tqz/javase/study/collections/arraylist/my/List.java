package com.tqz.javase.study.collections.arraylist.my;

/**
 * 手动实现list，定义接口
 *
 * @author tianqingzhao
 * @since 2023-05-13 19:35
 */
public interface List {

    public void add(Object obj);

    public int size();

    public Object get(int index);

    public boolean isEmpty();
}

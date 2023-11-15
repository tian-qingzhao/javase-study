package com.tqz.javase.study.collections.arraylist.my;

import java.util.Arrays;

/**
 * 手动实现ArrayList
 *
 * @author tianqingzhao
 * @since 2023-05-13 19:34
 */
public class ArrayList implements List {

    private Object[] elementData;

    private int size = 0;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
    }

    @Override
    public void add(Object obj) {
        if (elementData.length == size) {
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
        elementData[size++] = obj;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int index) {
        return elementData[index];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                builder.append(elementData[i]).append(",");
            } else {
                builder.append(elementData[i]);
            }

        }
        builder.append("]");
        return builder.toString();
    }
}

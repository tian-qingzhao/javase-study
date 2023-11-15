package com.tqz.javase.study.collections.map;

/**
 * Node节点的颜色
 */
public enum NodeColor {
    /**
     * 红色
     */
    red(1, "red"),
    /**
     * 会给色
     */
    black(2, "black");

    int color;
    String desc;

    NodeColor(int color, String desc) {
        this.color = color;
        this.desc = desc;
    }

   
}
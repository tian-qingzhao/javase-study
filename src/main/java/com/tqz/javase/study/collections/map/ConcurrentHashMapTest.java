package com.tqz.javase.study.collections.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tianqingzhao
 * @since 2023-06-22 13:08
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        System.out.println((1 << (16 - 1))); // 32768

        System.out.println(Integer.numberOfLeadingZeros(16) | 32768); // 32795

        int n = 16;
        int NCPU = Runtime.getRuntime().availableProcessors();
        System.out.println((NCPU > 1) ? (n >>> 3) / NCPU : n);

        System.out.println(95921 & 16);

        map.put("a", "1");
        map.put("b", "2");

        map.size();
    }
}

package com.tqz.javase.study.mutilthread;

/**
 * @author tianqingzhao
 * @since 2023-05-22 19:02
 */
public class Demo {

    private static final int HASH_INCREMENT = 0x61c88647;

    private int i = 0;

    public int incr() {
        i++;
        return i;
    }

    public static void main(String[] args) {
        magicHash(16);

        magicHash(32);
    }

    private static void magicHash(int size) {
        int hashCode = 0;
        for (int i = 0; i < size; i++) {
            hashCode = i * HASH_INCREMENT + HASH_INCREMENT;
            System.out.print((hashCode & (size - 1)) + " ");
        }
        System.out.println();
    }
}

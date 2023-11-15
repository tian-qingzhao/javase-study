package com.tqz.javase.study.collections.set;

import java.util.Comparator;

/**
 * 按照分数排序
 *
 * @author tianqingzhao
 * @since 2023-05-13 21:15
 */
public class StuScoreComparator implements Comparator<Student> {

    @Override
    public int compare(Student stu1, Student stu2) {
        if (stu1.getScore() > stu2.getScore()) {
            return 1;
        } else if (stu1.getScore() < stu2.getScore()) {
            return -1;
        } else {
            return 0;
        }

    }

}

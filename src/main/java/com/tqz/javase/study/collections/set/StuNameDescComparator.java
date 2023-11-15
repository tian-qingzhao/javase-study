package com.tqz.javase.study.collections.set;

import java.util.Comparator;

/**
 * 按照名字排序，名字如果一致，再按照id升序
 *
 * @author tianqingzhao
 * @since 2023-05-13 21:15
 */
public class StuNameDescComparator implements Comparator<Student> {

    @Override
    public int compare(Student stu1, Student stu2) {

        int result = stu1.getName().compareTo(stu2.getName());
        if (result != 0) {
            return result;
        } else {
            return stu1.getId() - stu2.getId();
        }
    }

}

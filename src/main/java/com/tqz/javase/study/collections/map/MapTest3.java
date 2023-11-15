package com.tqz.javase.study.collections.map;

import com.tqz.javase.study.collections.set.Student;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 功能：存储多个学生的信息
 * 解决：使用ArrayList
 *
 * <p>功能：存储多个学生的信息，要求根据学生学号（不是索引）快速的找到学生
 * 解决1：使用ArrayList可以很好的存储，就是按照学号查询效率低
 * 解决2：使用HashMap可以很好的存储（学号是key，学生是value），按照学号查询效率高，缺点：无序
 * 解决3：使用TreeMap可以很好的存储（学号是key，学生是value），按照学号查询效率高，有序（学号的大小）
 * 解决4：使用LinkedHashMap可以很好的存储（学号是key，学生是value），按照学号查询效率高，有序（添加的熟悉）
 *
 * <p>按照内容查询效率高低
 * 线性表（顺序表和链表）  <  树    < 哈希表
 *
 * <p>Entry是Map的子接口；在Map的实现类中给出了Entry的内部类的实现
 *
 * @author tianqingzhao
 * @since 2023-05-14 15:56
 */
public class MapTest3 {

    public static void main(String[] args) {
        //创建一个map集合对象
        Map<Integer, Student> stumap = new LinkedHashMap<Integer, Student>();
//		Map m1;
//		HashMap h1;
//		LinkedHashMap l1;
//		TreeMap t1;
        //添加学生信息
        Student stu1 = new Student(20, "李四", 20, 95);
        Student stu2 = new Student(10, "张三", 18, 90);
        Student stu3 = new Student(40, "王五", 19, 93);
        Student stu4 = new Student(30, "赵六", 20, 94);
        Student stu5 = new Student(10, "张三", 18, 90);
        stumap.put(stu1.getId(), stu1);
        stumap.put(stu2.getId(), stu2);
        stumap.put(stu3.getId(), stu3);
        stumap.put(stu4.getId(), stu4);
        stumap.put(stu5.getId(), stu5);

        //根据学号找学生
        System.out.println(stumap.size());//
        Student stu = stumap.get(10);//不仅代码简单，关键是速度快
        System.out.println(stu);
        stu = stumap.get(50);
        System.out.println(stu);
        //遍历所有学生
        Set<Map.Entry<Integer, Student>> entrySet = stumap.entrySet();
        Iterator<Map.Entry<Integer, Student>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Student> entry = it.next();
            System.out.println(entry.getKey() + "------->" + entry.getValue());
        }

    }
}

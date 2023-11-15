package com.tqz.javase.study.collections.set;

import java.util.Objects;

public class Student implements Comparable<Student> {

    private int id;
    private String name;
    private int age;
    private double score;

    public Student() {
        super();
    }

    public Student(int id, String name, int age, double score) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    /**
     * TreeSet的泛型对象必须要实现 {@link java.util.Comparator} 接口
     *
     * @param other 其他元素
     * @return 正数：>  ，
     * 零：== ，返回0的时候认为是同一个元素，set里面只会存在一个，因为set不重复
     * 负数 <
     */
    @Override
    public int compareTo(Student other) {
        return this.id - other.id;
//        return -(this.id - other.id);
//        return other.id - this.id;
//        return (int) (this.score - other.score);
//        if (this.score > other.score) {
//            return 1;
//        } else if (this.score < other.score) {
//            return -1;
//        } else {
//            return 0;
//        }
//        return this.name - other.name;
//        return this.name.compareTo(other.name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return id == student.id && age == student.age &&
                Double.compare(student.score, score) == 0 &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, score);
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + ", score=" + score + "]";
    }

}

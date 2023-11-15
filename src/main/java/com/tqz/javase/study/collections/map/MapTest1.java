package com.tqz.javase.study.collections.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * 功能：使用集合存储分数、课程、学生（List Set Collection）
 * 功能：根据学生学号快速的找到学生（映射关系   key---value 键---值  学号----学生）
 * 技能：Map
 *
 * <p>
 * 功能：存储国家简称和国家名称的对应关系 （cn---China）
 * 技能：Map
 *
 * <p>总结1：Map的特点
 * 1.HashMap
 * key：无序  唯一  HashSet
 * value：无序  不唯一  Collection
 * 2.LinkedHashMap
 * key：有序（添加顺序）  唯一  HashSet
 * value：无序  不唯一  Collection
 * 3.TreeMap
 * key：有序（自然顺序）  唯一  HashSet
 * value：无序  不唯一  Collection
 *
 * <p>总结2.：map的方法
 * map.put("cn", "China");
 * map.get("cn");
 * map.size()
 * map.keySet()
 * map.values()
 * map.entrySet()
 *
 * @author tianqingzhao
 * @since 2023-05-14 15:29
 */
public class MapTest1 {

    public static void main(String[] args) {
        //创建一个map来存储键值对
        //Map<String,String> map = new HashMap<String,String>();
        //Map<String,String> map = new LinkedHashMap<String,String>();
        Map<String, String> map = new TreeMap<String, String>();
        //添加键值对
        map.put("cn", "China");
        map.put("fr", "France");
        map.put("en", "England");
        map.put("us", "the United States");
        map.put("us", "America");//key相同
        map.put("uk", "England");//value相同
        //根据键找到值
        String value = map.get("cn");//不仅代码少，关键是速度快
        System.out.println(value);
        value = map.get("jp");
        System.out.println(value);
        //输出map元素个数
        System.out.println(map.size());
        //输出所有的key
        System.out.println(map.keySet());
        //输出所有的value
        System.out.println(map.values());
        //输出所有的key-value
        System.out.println(map.toString());
        System.out.println(map.entrySet().toString());

    }
}

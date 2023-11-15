package com.tqz.javase.study.collections.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * <p>总结3：如何遍历
 * map不能够直接遍历，转换成set再遍历
 * 遍历1：先得到所有的key，根据key再获取值
 * 遍历2：先得到所有的key-value，再从每个key-value中分别取出key和value
 *
 * <p>总结4：其他方法
 * map.remove("us"); key 不是index
 * map.isEmpty()
 * map.clear();
 * map.remove("us");
 * map.containsKey("us")
 * map.containsValue("Japan")
 *
 * @author tianqingzhao
 * @since 2023-05-14 15:43
 */
public class MapTest2 {

    public static void main(String[] args) {
        //创建一个map来存储键值对
        Map<String,String> map = new HashMap<String,String>();
//        Map<String,String> map = new LinkedHashMap<String,String>();
//        Map<String, String> map = new TreeMap<String, String>();
        //添加键值对
        map.put("cn", "China");
        map.put("fr", "France");
        map.put("en", "England");
        map.put("us", "the United States");
        map.put("us", "America");//key相同
        map.put("uk", "England");//value相同
        //map.get("us");
        map.remove("us");

        System.out.println(map.isEmpty());
//        map.clear();
        //遍历1：先得到所有的key，根据key再获取值
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + "----->" + map.get(key));
        }

        //遍历2：先得到所有的key-value，再从每个key-value中分别取出key和value
//		Set <Entry<String,String>>entrySet = map.entrySet();
//		for(Entry<String,String> entry:entrySet){
//			System.out.println(entry.getKey()+"----->"+entry.getValue());
//		}

        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, String>> it = entrySet.iterator();
        while (it.hasNext()) {
            //取出来
            Map.Entry<String, String> entry = it.next();
            //输出去
            //System.out.println(entry);
            System.out.println(entry.getKey() + "================>" + entry.getValue());
        }

    }
}

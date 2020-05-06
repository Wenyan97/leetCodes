package com.JavaSE;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args){

        /**
         *  putIfAbsent(K key, V value)   如果传入key对应的value已经存在，就返回存在的value，不进行替换。
         *      如果不存在或为 get(key)为null，就添加key和value，返回null（简单讲就是返回前一个值）
         */

            String ret;
            Map<String, String> map = new HashMap<>();
            ret = map.putIfAbsent("a", "aaa");
//        null {a=aaa}
            System.out.println(ret + " " + map);

            ret = map.putIfAbsent("a", "bbb");
//        aaa {a=aaa}
            System.out.println(ret + " " + map);

            map.put("b", null);
            ret = map.putIfAbsent("b", "bbb");
//        null {a=aaa, b=bbb}
            System.out.println(ret + " " + map);


    }
}

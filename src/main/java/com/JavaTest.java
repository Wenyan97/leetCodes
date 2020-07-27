package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JavaTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "tom");
        map.put(2, "john");
        map.put(3, "jerry");
        map.put(4, "allen");
        map.put(5, "ketty");
        for (int n : map.keySet()) {
            System.out.println(map.get(n));
        }

        Set set = map.entrySet();
        System.out.println(set.stream());

        System.out.println(Integer.MAX_VALUE);
    }
}

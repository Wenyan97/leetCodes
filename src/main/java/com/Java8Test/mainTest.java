package com.Java8Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class mainTest /*implements Comparator<String>*/{
    public static void main(String[] args) {
        /**
         * java7进行降序排序
         */
        List<String> names = Arrays.asList("peter", "anna", "mike", "john", "bob");
       /* Comparator<String> comparator = new mainTest();
        Collections.sort(names, comparator);
        System.out.println(names);*/
        /* Collections.sort(names);
        System.out.println();
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(names.getClass());
        System.out.println(names);*/
    }
//
//    @Override
//    public int compare(String o1, String o2) {
//        return o2.compareTo(o1);
//    }
}

package com;

import java.util.HashMap;
import java.util.Map;

public class JavaTest extends Thread{
    public synchronized void run() {
        for (int i = 0; i <= 10; i++) {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + ": " + i);
        }
    }
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "tom");
        map.put(2, "john");
        map.put(3, "jerry");
        map.put(4, "allen");
        map.put(5, "ketty");

        JavaTest obj = new JavaTest();
        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj);
        Thread t3 = new Thread(obj);

        t1.start();
        t2.start();
        t3.start();
    }
}

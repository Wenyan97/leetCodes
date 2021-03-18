package com.leetcode250;

import java.util.HashMap;
import java.util.Map;


public class LRUCache {
    class Node {
        public int key, val;
        public Node next, prev;
        public Node (int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    class DoubleList {

        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);
        int size;

        public DoubleList () {
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        // 链表头部添加数据
        public void addFirst (Node x) {
            x.next = head.next;
            head.next.prev = x;
            head.next = x;
            x.prev = head;
            size++;
        }

        public void remove (Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public Node removeLast () {
            Node last = tail.prev;
            remove(last);
            return last;
        }

        public int size (){
            return size;
        }

    }


    public Map<Integer, Node> map;

    public DoubleList cache;

    public int capacity;

    public LRUCache (int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        Node x = new Node(key, val);
        if (map.containsKey(key)) {
            cache.remove(x);
            cache.addFirst(x);
            map.put(key, x);
        } else {
            if (this.capacity == cache.size()) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);
            map.put(key, x);
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3

    }
}
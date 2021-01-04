package com.leetcode3.Tree.BST;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.datastructures.TreeNode;

public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        
        return null;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new TreeMap<>();
        map.put(1, 10);
        map.put(444, 33);
        map.put(33, 2);
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}

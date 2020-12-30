package com.leetcode3.Tree.BST;

import java.util.HashMap;
import java.util.Map;

import com.datastructures.TreeNode;


public class ClosestBinarySearchTreeValue {
    // public int closestValue(TreeNode root, double target) {
    //     if (root == null) {
    //         return Integer.MIN_VALUE;
    //     }
    
    //     if (target < root.val) {
    //         if (root.left != null) {
    //             int left = closestValue(root.left, target);
    //             if (Math.abs(left - target) < Math.abs(root.val - target)) {
    //                 return left; 
    //             }
    //         } 
            
    //     } else if (target > root.val) {
    //         if (root.right != null) {
    //             int right = closestValue(root.right, target);
    //             if (Math.abs(right - target) < Math.abs(root.val - target)) {
    //                 return right; 
    //             }
    //         } 
    //     } 
        
    //     return root.val;
    // }


    double sum = Integer.MAX_VALUE;
    Map<Double, Integer> map = new HashMap<>();
    public int closestValue(TreeNode root, double target) {
        // write your code here
        dfs(root, target);
        return map.get(sum);
    }


    public void dfs(TreeNode root, double target) {
        if (root == null) return;
        double tmp = Math.abs(target - root.val);
        map.put(tmp, root.val);
        sum = Math.min(tmp, sum);
        dfs(root.left, target);
        dfs(root.right, target);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(10);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        ClosestBinarySearchTreeValue solution = new ClosestBinarySearchTreeValue();
        int a = solution.closestValue(node1, 6.124232);
        System.out.println(a);
    }
}

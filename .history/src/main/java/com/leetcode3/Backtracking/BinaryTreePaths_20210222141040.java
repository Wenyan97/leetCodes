package com.leetcode3.Backtracking;

import java.util.ArrayList;
import java.util.List;

import com.datastructures.TreeNode;


public class BinaryTreePaths {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        backtracking(root, new StringBuilder("" + root.val));
        return res;
    }

    public void backtracking(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            res.add(sb.toString());
            return;            
        } else {
            sb.append("->").append(root.val);
        }
        backtracking(root.left, sb);
        backtracking(root.right, sb);
        sb.setLength(sb.length() - 3);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        BinaryTreePaths solution = new BinaryTreePaths();
        solution.binaryTreePaths(node1);


    }
}

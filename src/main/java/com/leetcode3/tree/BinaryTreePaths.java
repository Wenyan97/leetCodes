package com.leetcode3.tree;

import com.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return ans;
        dfs(root, new StringBuilder());
        return ans;
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        int len = sb.length();
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            ans.add(sb.toString());
            sb.delete(len, sb.length());
        } else sb.append(root.val).append("->");
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.delete(len, sb.length());
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        BinaryTreePaths so = new BinaryTreePaths();
        List<String> ans = so.binaryTreePaths(node1);
        System.out.println(123);
    }
}

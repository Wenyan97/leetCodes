package com.leetcode3.Tree.preorder;

import com.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        StringBuilder sb = new StringBuilder("");
        dfs(root, sb);
        return res;
    }

    public void dfs(TreeNode root,  StringBuilder sb) {
        if (root == null) return;
        int len = String.valueOf(root.val).length();
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            res.add(sb.toString());
            sb.delete(sb.length() - len, sb.length());
            /*if (root.val >= 0) {
                sb.setLength(sb.length() - String.valueOf(root.val).length());
            } else sb.setLength(sb.length() - 1 - String.valueOf(root.val).length());*/
            return;
        } else {
            sb.append(root.val).append("->");
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.delete(sb.length() - 2 - len, sb.length());
    }


    public static void main(String[] args) {
        BinaryTreePaths solution = new BinaryTreePaths();
        TreeNode node1 = new TreeNode(-1);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        List<String> list = solution.binaryTreePaths(node1);
        System.out.println(list);
    }
}

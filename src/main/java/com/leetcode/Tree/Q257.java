package com.leetcode.Tree;

import com.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 */
public class Q257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) return ans;
        if (root.left == null && root.right == null) {
            ans.add(root.val + "");
        }
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String leftPath : leftPaths) {
            ans.add(root.val + "->" + leftPath);
        }
        for (String rightPath : rightPaths) {
            ans.add(root.val + "->" + rightPath);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        Q257 solution = new Q257();
        solution.binaryTreePaths(node1);
        System.out.println(222);
    }
}

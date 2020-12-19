package com.leetcode3.Tree.preorder;

import com.datastructures.TreeNode;

public class BinaryLongestConsecutiveSequence {
    int sum = 1;
    public int longestConsecutive(TreeNode root) {
        // write your code here
        if (root == null) return 0;
        dfs(root, 1);
        return sum;

    }

    public void dfs(TreeNode root, int curr) {
        if (root == null) return;
        sum = Math.max(sum, curr);
        if (root.left != null) {
            if (root.left.val - 1 == root.val) {
                dfs(root.left, curr + 1);
            } else dfs(root.left, 1);
        }
        if (root.right != null) {
            if (root.right.val - 1 == root.val) {
                dfs(root.right, curr + 1);
            } else dfs(root.right, 1);
        }

    }

    public static void main(String[] args) {
        BinaryLongestConsecutiveSequence solution = new BinaryLongestConsecutiveSequence();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        /*node1.right = node2;
        node2.left = node3;
        node2.right = node4;
        node4.right = node5;*/
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        System.out.println(solution.longestConsecutive(node1));

    }
}

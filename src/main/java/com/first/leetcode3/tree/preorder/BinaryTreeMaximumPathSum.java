package com.first.leetcode3.tree.preorder;

import com.datastructures.TreeNode;

public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        getMax(root);
        return max;
    }

    public void getMax(TreeNode root) {
        if (root == null) return;
        max = Math.max(max, getSum(root, 0));
        getMax(root.left);
        getMax(root.right);
    }

    public int getSum(TreeNode root, int currSum) {
        if (root == null) return 0;
        currSum += root.val;
        if (root.left != null) {
            currSum += getSum(root.left, 0);
        }
        if (root.right != null) {
            currSum += getSum(root.right, 0);
        }
        return currSum;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        BinaryTreeMaximumPathSum so = new BinaryTreeMaximumPathSum();
        System.out.println(so.maxPathSum(node1));

    }
}

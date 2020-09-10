package com.first.leetcode.Tree;

import com.datastructures.TreeNode;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 *
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 */
public class BinaryTreeLongestConsecutiveSequence {
    int maxSum = Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1);
        return maxSum;
    }

    //lintCode 80%
    public void dfs(TreeNode root, int currlength) {
        if (root == null) return;
        if (root.left != null) {
            if (root.left.val - root.val == 1) {
                currlength += 1;
            } else {
                currlength = 1;
            }
            maxSum = Math.max(maxSum, currlength);
            dfs(root.left, currlength);
        }
        if (root.right != null) {
            if (root.right.val - root.val == 1) {
                currlength += 1;
            } else {
                currlength = 1;
            }
            maxSum = Math.max(maxSum, currlength);
            dfs(root.right, currlength);
        }
    }

    //lintcodes 100%
    public void dfs2(TreeNode root, int currlength) {
        if (root == null) return;
        maxSum = Math.max(maxSum, currlength);
        if (root.left != null) {
            if (root.left.val - root.val == 1) {
                dfs(root.left, currlength + 1);
            } else {
                dfs(root.left, 1);
            }
        }
        if (root.right != null) {
            if (root.right.val - root.val == 1) {
                dfs(root.right, currlength + 1);
            } else {
                dfs(root.right, 1);
            }
        }
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.right = node2;
        node2.left = node3;
        node2.right = node4;
        node4.right = node5;
        BinaryTreeLongestConsecutiveSequence solution = new BinaryTreeLongestConsecutiveSequence();
        System.out.println(solution.longestConsecutive(node1));
    }
}

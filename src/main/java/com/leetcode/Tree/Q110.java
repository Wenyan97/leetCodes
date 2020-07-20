package com.leetcode.Tree;

import com.datastructures.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */
public class Q110 {
    int minDepth = Integer.MAX_VALUE;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = findMaxDepth(root.left);
        int right = findMaxDepth(root.right);
        if (Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int findMaxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(findMaxDepth(root.left), findMaxDepth(root.right)) + 1;
    }
    
   /* public void dfs(TreeNode root, int currDepth) {
        if (root == null) return;
        currDepth++;
        if (root.left == null && root.right == null && currDepth < minDepth) {
            minDepth = currDepth;
        }
        dfs(root.left, currDepth);
        dfs(root.right, currDepth);
    }*/
}

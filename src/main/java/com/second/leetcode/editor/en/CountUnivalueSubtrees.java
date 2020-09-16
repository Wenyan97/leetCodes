package com.second.leetcode.editor.en;

import com.datastructures.TreeNode;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 *
 * A Uni-value subtree means all nodes of the subtree have the same value.
 *
 * Example
 * Example1
 *
 * Input:  root = {5,1,5,5,5,#,5}
 * Output: 4
 * Explanation:
 *               5
 *              / \
 *             1   5
 *            / \   \
 *           5   5   5
 * Example2
 *
 * Input:  root = {1,3,2,4,5,#,6}
 * Output: 3
 * Explanation:
 *               1
 *              / \
 *             3   2
 *            / \   \
 *           4   5   6
 */
public class CountUnivalueSubtrees {
    int sum = 0;
    public int countUnivalSubtrees(TreeNode root) {
        // write your code here
        if (root == null) return 0;
        if (isCountUnivalTree(root)) sum ++;
        countUnivalSubtrees(root.left);
        countUnivalSubtrees(root.right);
        return sum;
    }

    public boolean isCountUnivalTree(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        boolean left = isCountUnivalTree(root.left);
        boolean right = isCountUnivalTree(root.right);
        if (root.left != null && root.right != null) {
            if (left && right && root.left.val == root.right.val && root.val == root.left.val) {
                return true;
            }
        }
        if (root.left == null) {
            if (left && root.val == root.right.val) return true;
        }
        if (root.right == null) {
            if (right && root.val == root.left.val) return true;
        }
        return false;

    }

    public static void main(String[] args) {
        CountUnivalueSubtrees solution = new CountUnivalueSubtrees();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        solution.countUnivalSubtrees(node1);
        System.out.println("hello");

    }

}

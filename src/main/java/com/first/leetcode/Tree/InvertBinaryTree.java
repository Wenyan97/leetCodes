package com.first.leetcode.Tree;

import com.datastructures.TreeNode;

/**
 * Invert a binary tree.
 * Example:
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tmp;
        /*root.left = invertTree(root.left);
        root.right = invertTree(root.right);*/
        return root;
    }
}

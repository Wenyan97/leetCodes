package com.leetcodes;
/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 */
public class Q450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        return helper(root, key);
    }

    public TreeNode helper(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = helper(root.left, key);
        } else if (root.val < key) {
            root.right = helper(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode t = root;
            root = min(t.right);
            root.right = delteteMin(t.right);
            root.left = t.left;
        }
        return root;
    }

    // 找后继节点
    public TreeNode min(TreeNode root) {
        if (root.left == null) return root;
        return min(root.left);
    }

    public TreeNode delteteMin(TreeNode root) {
        if (root.left == null) return root.right;
        root.left = delteteMin(root.left);
        return root;
    }
}

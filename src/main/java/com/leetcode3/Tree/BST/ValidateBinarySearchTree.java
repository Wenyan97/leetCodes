package com.leetcode3.Tree.BST;

import java.util.List;

import com.datastructures.TreeNode;

class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, TreeNode max, TreeNode min) {
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return helper(root.left, root, min) && helper(root.right, max, root);
    }
}
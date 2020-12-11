package com.leetcode3.Tree;

import com.datastructures.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root, root);
    }


    public boolean helper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return root1.val == root2.val
                && helper(root1.left, root2.right)
                && helper(root1.right, root2.left);
    }
}

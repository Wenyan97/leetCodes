package com.leetcode3.Tree.preorder;

import com.datastructures.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1;
    }

    public int getDepth(TreeNode root) {
        return root == null ? 0 : Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}

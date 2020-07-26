package com.leetcode.Tree;

import com.datastructures.TreeNode;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int countLeft = countNodes(root.left);
        int countRight = countNodes(root.right);
        return countLeft + countRight + 1;
    }
}

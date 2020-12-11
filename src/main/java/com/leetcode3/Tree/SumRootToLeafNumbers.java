package com.leetcode3.Tree;

import com.datastructures.TreeNode;

public class SumRootToLeafNumbers {
    int resSum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return resSum;
        dfs(root, 0);
        return resSum;
    }

    public void dfs(TreeNode root, int currSum) {
        if (root == null) return;
        currSum += root.val;
        if (root.left == null && root.right == null) {
            resSum += currSum;
        }
        dfs(root.left, currSum * 10);
        dfs(root.right, currSum * 10);
    }
}

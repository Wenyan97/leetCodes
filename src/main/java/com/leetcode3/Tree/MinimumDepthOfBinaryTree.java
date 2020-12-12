package com.leetcode3.Tree;


import com.datastructures.TreeNode;

public class MinimumDepthOfBinaryTree {
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1);
        return min;
    }


    public void dfs(TreeNode root, int currDepth) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            min = Math.min(min, currDepth);
        }
        dfs(root.left, currDepth + 1);
        dfs(root.right, currDepth + 1);
    }


}

package com.leetcode.Tree;

import com.datastructures.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 */
public class MinimumDepthOfBinaryTree {
    int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return minDepth;
    }

    public void dfs(TreeNode root, int currDepth) {
        if (root == null) return;
        currDepth++;
        if (root.left == null && root.right == null && currDepth < minDepth) {
            minDepth = currDepth;
        }
        dfs(root.left, currDepth);
        dfs(root.right, currDepth);
    }
}

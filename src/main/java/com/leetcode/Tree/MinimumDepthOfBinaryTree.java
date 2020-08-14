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


    /**
     * 递归，将该函数看作已经写好的函数，不去管内部细节，分类讨论即可
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
        // 右子树为空，则只关注左子树
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        // 其他情况
        return minDepth(root.right) + 1;
    }
}

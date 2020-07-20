package com.leetcode.Tree;

import com.datastructures.TreeNode;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 */
public class BinaryTreeMaximumPathSum {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return ans;
    }

    public int maxGain(TreeNode root) {
        if (root == null) return 0;
        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int left = Math.max(0, maxGain(root.left));
        int right = Math.max(0, maxGain(root.right));

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值, // 更新答案
        ans = Math.max(ans, left + right + root.val);

        // 返回节点的最大贡献值
        return Math.max(left, right) + root.val;
    }
}

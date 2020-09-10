package com.first.leetcodes;

/**
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class Q404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root);
    }

    public int helper(TreeNode node) {
        int sum = 0;
        if (node == null) {
            return 0;
        }
        if (node.left != null && (node.left.left == null && node.left.right == null)) {
            sum += node.left.val;
        }
        return sum + helper(node.left) + helper(node.right);
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        Q404 solution = new Q404();
        System.out.println(solution.sumOfLeftLeaves(node1));
    }
}

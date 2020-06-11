package com.leetcodes;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 */
public class Q111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
//        node1.right = node3;
        Q111 solution = new Q111();
        System.out.println(solution.minDepth(node1));
    }
}

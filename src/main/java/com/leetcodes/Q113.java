package com.leetcodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class Q113 {
    List<List<Integer>> allPathList = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root != null) dfs(root, sum);
        return allPathList;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) return;
        tmp.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            allPathList.add(new ArrayList<>(tmp));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        tmp.remove(tmp.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(2);
        TreeNode node10 = new TreeNode(5);
        TreeNode node11 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        node7.left = node10;
        node7.right = node11;
        Q113 solution = new Q113();
        solution.allPathList = solution.pathSum(node1, 22);
        System.out.println(solution.allPathList);
    }
}

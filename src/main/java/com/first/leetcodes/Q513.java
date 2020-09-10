package com.first.leetcodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * 示例 1:
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 * 输出:
 * 1
 *  
 *
 * 示例 2:
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 * 输出:
 * 7
 */
public class Q513 {
    public int findBottomLeftValue(TreeNode root) {
        if (root.right == null && root.left == null) {
            return root.val;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = getDepth(root);
        int index = 1;//第一层
        List<TreeNode> ansList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int length = queue.size();
            index++;
            for (int i = 0; i < length; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                    //判断是否为最后一层，是则添加
                    if (index == depth) {
                        ansList.add(tmp.left);
                    }
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                    //判断是否为最后一层，是则添加
                    if (index == depth) {
                        ansList.add(tmp.right);
                    }
                }
            }
        }
        return ansList.get(0).val;
    }

    public int getDepth(TreeNode root) {
        return root == null ? 0 : Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        Q513 solution = new Q513();
        System.out.println(solution.findBottomLeftValue(node1));
    }
}

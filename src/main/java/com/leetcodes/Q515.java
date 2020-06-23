package com.leetcodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 您需要在二叉树的每一行中找到最大的值。
 * 示例：
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 */
public class Q515 {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> maxList = new ArrayList<>();//存放每行最大值数组
        Queue<TreeNode> queue = new LinkedList<>();
        //加入根节点
        maxList.add(root.val);
        queue.offer(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            int maxTmp = Integer.MIN_VALUE;
            for (int i = 0; i < length; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                    if (tmp.left.val > maxTmp) {
                        maxTmp = tmp.left.val;
                    }
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                    if (tmp.right.val > maxTmp) {
                        maxTmp = tmp.right.val;
                    }
                }
            }
            maxList.add(maxTmp);
        }
        maxList.remove(maxList.size() - 1);
        return maxList;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(9);
        node1.left =node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        Q515 solution = new Q515();
        System.out.println(solution.largestValues(node1));
    }
}

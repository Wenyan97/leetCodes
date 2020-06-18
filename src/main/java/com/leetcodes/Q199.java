package com.leetcodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class Q199 {
    List<TreeNode> queue = new LinkedList<>();
    List<Integer> rightSideList;
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        rightSideList = new ArrayList<>();
        BFS(root);
        return rightSideList;
    }

    public void BFS(TreeNode root) {
        if (root == null) return;
        queue.add(root);
        rightSideList.add(root.val);
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode tmp = queue.remove(0);
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
            }
            if (!queue.isEmpty()) {
                rightSideList.add(queue.get(queue.size() - 1).val);
            }
        }
    }
    public static void main(String[] args) {
        Q199 solution = new Q199();
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
        solution.rightSideView(node1);
        System.out.println(solution.rightSideList);
    }

}

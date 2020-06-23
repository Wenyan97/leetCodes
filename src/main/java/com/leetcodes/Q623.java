package com.leetcodes;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
 *
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
 *
 * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
 *
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 */
public class Q623 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) {
            return root;
        }
        if (d == 1) {
            TreeNode head = new TreeNode(v);
            head.left = root;
            return head;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    if (index == d - 1 ) {
                        TreeNode node = new TreeNode(v);
                        node.left = tmp.left;
                        tmp.left = node;
                    }
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    if (index == d - 1) {
                        TreeNode node = new TreeNode(v) ;
                        node.right = tmp.right;
                        tmp.right = node;
                    }
                    queue.offer(tmp.right);
                }
            }

            if (index == d - 1) {
                break;
            }
            index++;

        }
        return root;
    }


    public TreeNode addOneRow2(TreeNode root, int v, int d) {
        if (root == null) {
            return root;
        }
        if (d == 1) {
            TreeNode head = new TreeNode(v);
            head.left = root;
            return head;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            index++;
            for (int i = 0; i < len; i++) {
                TreeNode tmp = queue.poll();
                if (index == d) {
                    TreeNode nodeL = new TreeNode(v);
                    if (tmp.left != null) {
                        nodeL.left = tmp.left;
                    }
                    tmp.left = nodeL;

                    TreeNode nodeR = new TreeNode(v) ;
                    if (tmp.right != null){
                        nodeR.right = tmp.right;
                    }
                    tmp.right = nodeR;

                } else {
                    if (tmp.left != null) {
                        queue.offer(tmp.left);
                    }
                    if (tmp.right != null) {
                        queue.offer(tmp.right);
                    }
                }
            }
            if (index == d) {
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        Q623 solution = new Q623();
        solution.addOneRow(node1,5,4);
        System.out.println(node4.left.val + " ---" + node4.right.val);
    }

}

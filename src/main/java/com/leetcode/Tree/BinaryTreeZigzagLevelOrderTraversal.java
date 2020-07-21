package com.leetcode.Tree;

import com.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //1：左往右     -1：右往左
        int flag = 1;
        while (!queue.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode tmp = queue.remove();
                if (flag == 1) {
                    tmpList.add(tmp.val);
                } else {
                    tmpList.add(0, tmp.val);
                }
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            //将方向置反
            flag = flag == 1 ? -1 : 1;
            ans.add(tmpList);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        BinaryTreeZigzagLevelOrderTraversal solution = new BinaryTreeZigzagLevelOrderTraversal();
        List<List<Integer>> ans = solution.zigzagLevelOrder(node1);
        System.out.println("sdsds");
    }
}

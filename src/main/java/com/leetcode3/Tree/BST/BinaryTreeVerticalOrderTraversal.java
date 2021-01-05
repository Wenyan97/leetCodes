package com.leetcode3.Tree.BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.datastructures.TreeNode;


public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> tagQueue = new LinkedList<>();
        // treemap保证有序
        Map<Integer, List<Integer>> qMap = new TreeMap<>();
        queue.offer(root);
        tagQueue.offer(0);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode tmp = queue.poll();
                int tmpInt = tagQueue.poll();
                if (!qMap.containsKey(tmpInt)) {
                    List<Integer> tmplist = new ArrayList<>();
                    tmplist.add(tmp.val);
                    qMap.put(tmpInt, tmplist);
                } else {
                    qMap.get(tmpInt).add(tmp.val);
                }
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                    tagQueue.offer(tmpInt - 1);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                    tagQueue.offer(tmpInt + 1);
                }
            }
        }
        for (Integer entry : qMap.keySet()) {
            list.add(qMap.get(entry));
        }
        return list;
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
        BinaryTreeVerticalOrderTraversal solution = new BinaryTreeVerticalOrderTraversal();
        List<List<Integer>> list = solution.verticalOrder(node1);

    }
}

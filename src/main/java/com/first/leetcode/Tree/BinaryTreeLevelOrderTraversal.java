package com.first.leetcode.Tree;

import com.datastructures.TreeNode;
import com.first.leetcode.TreeCreator;

import java.util.*;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        queue.offer(root);
        List<Integer> list1 = new ArrayList<>();
        list1.add(root.val);
        ans.add(list1);
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                    tmpList.add(tmp.left.val);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                    tmpList.add(tmp.right.val);
                }
            }
            if (tmpList.size() != 0) {
                ans.add(tmpList);
            }
        }
        return ans;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        //按层遍历即可
        //1.
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        //2.
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode remove = nodes.remove(0);
                list.add(remove.val);
                if (remove.left != null) {
                    nodes.add(remove.left);
                }
                if (remove.right != null) {
                    nodes.add(remove.right);
                }
            }
            lists.add(list);
        }
        return lists;
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
        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
        int[] list = new int[]{1,2,4,5,6,7};
        TreeNode node7 = TreeCreator.bulidBST(list);
        List<List<Integer>> ans = solution.levelOrder(node1);
        System.out.println("ssss");
    }
}

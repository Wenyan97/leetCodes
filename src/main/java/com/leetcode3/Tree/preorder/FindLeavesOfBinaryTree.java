package com.leetcode3.Tree.preorder;

import com.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        while (root != null) {
            List<Integer> list = new ArrayList<>();
            root = dfs(root, list);
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }

    public TreeNode dfs(TreeNode root, List<Integer> list) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        }
        root.left = dfs(root.left, list);
        root.right = dfs(root.right, list);
        return root;
    }

    public static void main(String[] args) {
        FindLeavesOfBinaryTree solution = new FindLeavesOfBinaryTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        List<List<Integer>> list = solution.findLeaves(node1);
        System.out.println(list);
    }
}

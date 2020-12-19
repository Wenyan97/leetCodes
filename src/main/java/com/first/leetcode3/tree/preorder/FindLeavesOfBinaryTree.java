package com.first.leetcode3.tree.preorder;

import com.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindLeavesOfBinaryTree {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    Set<TreeNode> set = new HashSet<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) return ans;
        // write your code here
        TreeNode p = root;
        initSet(root);
        while (!set.isEmpty()) {
            collectLeaves(root);
            ans.add(new ArrayList<>(list));
            list.clear();
        }
        return ans;
    }

    public void initSet(TreeNode root) {
        if (root == null) return;
        set.add(root);
        initSet(root.left);
        initSet(root.right);
    }

    public TreeNode collectLeaves(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            set.remove(root);
            return null;
        }
        root.left = collectLeaves(root.left);
        root.right = collectLeaves(root.right);
        return root;
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
        FindLeavesOfBinaryTree so = new FindLeavesOfBinaryTree();
//        so.collectLeaves(node1);
        so.findLeaves(node1);
        System.out.println(12);
    }
}

package com.leetcode3.Tree.BST;

import com.datastructures.TreeNode;


public class KthSmallestElementInABST {
    TreeNode ans = new TreeNode();
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans.val;
    }


    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        k--;
        if (k == 0) {
            ans.val = root.val;
        }
        dfs(root.right);
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        KthSmallestElementInABST solution = new KthSmallestElementInABST();
        int a = solution.kthSmallest(node1, 1);
        System.out.println(a);
    }
}

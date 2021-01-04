package com.leetcode3.Tree.BST;

import com.datastructures.TreeNode;


public class BinaryTreeUpsideDown {
    // 右节点在的时候左节点一定在
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // write your code here
        if (root == null) return null;
        TreeNode newRoot = findNewRoot(root);
        dfs(root);
        return newRoot;
    }

    public TreeNode findNewRoot(TreeNode root) {
        TreeNode t = root;
        while (t.left != null) {
            t = t.left;
        }
        return t;
    }


    public void dfs(TreeNode root) {
        // write your code here
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        dfs(root.left);
        if (root.right != null) {
            root.left.left = root.right;
        } else {
            root.left.left = null;
            
        }
        root.left.right = root;
        root.right = null;
        root.left = null;
        dfs(root.right);
        
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
        BinaryTreeUpsideDown solution = new BinaryTreeUpsideDown();
        TreeNode root = solution.upsideDownBinaryTree(node1);

    }
}

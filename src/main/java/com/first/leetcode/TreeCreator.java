package com.first.leetcode;

import com.datastructures.TreeNode;

public class TreeCreator {
    public static TreeNode bulidBST(int[] A) {
        TreeNode root = new TreeNode(A[0]);
        for (int i=1; i<A.length; i++) {
            createBST(root, A[i]);
        }
        return root;
    }

    private static void createBST(TreeNode node, int val) {
        if (val<node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else
                createBST(node.left, val);
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else
                createBST(node.right, val);
        }
    }

}

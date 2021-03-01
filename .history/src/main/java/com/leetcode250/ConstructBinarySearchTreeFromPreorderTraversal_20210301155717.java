package com.leetcode250;

import com.datastructures.TreeNode;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }

    public TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(preorder[start]);
        int index = start;
        while (preorder[index] < root.val) {
            index++;
        }
        root.left = bstFromPreorder(preorder, start + 1, index - 1);
        root.right = bstFromPreorder(preorder, index, end);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinarySearchTreeFromPreorderTraversal so = new ConstructBinarySearchTreeFromPreorderTraversal();
        int[] preorder = {8,5,1,7,10,12};
        TreeNode root = so.bstFromPreorder(preorder);
        System.out.println(1212);
    }
}

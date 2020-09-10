package com.first.leetcode.Tree;

import com.datastructures.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1,
                      inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int pLeft, int pRight,
                           int[] inorder, int iLeft, int iRight) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        if (pLeft > pRight || iLeft > iRight) return null;
        TreeNode root = new TreeNode(preorder[pLeft]);
        int rootIndex = 0;
        while (inorder[rootIndex] != root.val) {
            rootIndex++;
        }
        int leftLen = rootIndex - iLeft;
        root.left = helper(preorder, pLeft + 1, pLeft + leftLen,
                           inorder, iLeft, rootIndex - 1);
        root.right = helper(preorder, pLeft + leftLen + 1, pRight,
                            inorder, rootIndex + 1, iRight);
        return root;
    }
}

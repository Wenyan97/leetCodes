package com.first.leetcode.Tree;

import com.datastructures.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1,
                      postorder, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int iLeft, int iRight,
                           int[] postorder, int poLeft, int poRight) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        if (iLeft > iRight || poLeft > poRight) return null;
        TreeNode root = new TreeNode(postorder[poRight]);
        int rootIndex = 0;
        while (inorder[rootIndex] != root.val) {
            rootIndex++;
        }
        int rightLen = iRight - rootIndex;
        root.left = helper(inorder, iLeft, rootIndex - 1,
                           postorder, poLeft, poRight - rightLen - 1);
        root.right = helper(inorder, rootIndex + 1, iRight,
                            postorder, poRight - rightLen, poRight - 1);
        return root;
    }
}

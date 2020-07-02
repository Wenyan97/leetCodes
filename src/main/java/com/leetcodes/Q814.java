package com.leetcodes;

public class Q814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        //删除值为0的叶子节点
        if (root.left == null && root.right == null) {
            if (root.val == 0) {
                return null;
            }
        }
        return root;
    }
}

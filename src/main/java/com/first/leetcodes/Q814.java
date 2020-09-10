package com.first.leetcodes;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Q814 solution = new Q814();
        list.add(3);
    }
}

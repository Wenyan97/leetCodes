package com.leetcode3.Tree.BST;

import java.util.ArrayList;
import java.util.List;

import com.datastructures.TreeNode;

public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode xNode = null;
        TreeNode yNode = null;
        dfs(root, list);
        // 找出两个节点
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val) {
                xNode = list.get(i + 1);
                if (yNode == null) {
                    yNode = list.get(i);
                }
            }
        }

        // 交换节点
        if (xNode != null && yNode != null) {
            int tmp = xNode.val;
            xNode.val = yNode.val;
            yNode.val = tmp;
        }
    }


    public void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }
}

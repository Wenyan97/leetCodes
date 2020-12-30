package com.leetcode3.Tree.BST;

import java.util.LinkedList;
import java.util.List;

import com.datastructures.TreeNode;

/**
 * Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.
 * If the given node has no in-order successor in the tree, return null.
 */
public class InorderSuccessorInBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null) ? left : root;
        }
    }


    // public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    //     // write your code here
    //     if (root == null) return null;
    //     if (root.left == null && root.right == null) return null;
    //     List<TreeNode> list = new ArrayList<>();
    //     dfs(root, list);
    //     int val = p.val;
    //     for (int i = 0; i < list.size(); i++) {
    //         if (list.get(i).val != val) {
    //             continue;
    //         } else return list.get(i + 1);
    //     }
    //     return null;
    // }

    // public void dfs(TreeNode root, List<TreeNode> list) {
    //     if (root == null) return;
    //     dfs(root.left, list);
    //     list.add(root);
    //     dfs(root.right, list);
    // }


}

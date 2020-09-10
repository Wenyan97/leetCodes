package com.first.leetcode.Tree.BST;

import com.datastructures.TreeNode;

import java.util.Stack;

public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        boolean flag = false;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (flag) return curr;
            if (curr.val == p.val) {
                flag = true;
            }
            curr = curr.right;
        }
        return null;
    }
}

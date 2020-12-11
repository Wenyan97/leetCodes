package com.leetcode3.Tree;

import com.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            list.addFirst(tmp.val);
            if (tmp.left != null) stack.push(tmp.left);
            if (tmp.right != null) stack.push(tmp.right);
        }
        return list;
    }
}

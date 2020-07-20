package com.leetcode.Tree;

import com.datastructures.TreeNode;
import org.w3c.dom.html.HTMLLinkElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            ans.addFirst(tmp.val);
            if (tmp.left != null) {
                stack.add(tmp.left);
            }
            if (tmp.right != null) {
                stack.add(tmp.right);
            }
        }
        return ans;
    }
}

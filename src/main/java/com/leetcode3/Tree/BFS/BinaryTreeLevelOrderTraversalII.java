package com.leetcode3.Tree.BFS;

import com.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return ans;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode tmp = queue.poll();
                list.add(tmp.val);
                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);
            }
            ans.addFirst(list);
        }
        return ans;
    }

    public static void main(String args[]) {
        System.out.println("hello world!!");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}

package com.leetcode3.Tree.BFS;

import com.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                TreeNode tmp = queue.poll();
                if (flag) {
                    list.addFirst(tmp.val);
                } else {
                    list.add(tmp.val);
                }
                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);
            }
            flag = !flag;
            res.add(list);
        }
        return res;
    }
}

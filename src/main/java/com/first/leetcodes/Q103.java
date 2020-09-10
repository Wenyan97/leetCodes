package com.first.leetcodes;

import com.datastructures.TreeNode;

import java.util.*;

public class Q103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int flag = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                tmp.add(node.val);
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
            if (flag == 1) {
                Collections.reverse(tmp);
                res.add(tmp);
                flag = -1;
            } else {
                res.add(tmp);
                flag = 1;
            }
        }
        return res;
    }
}

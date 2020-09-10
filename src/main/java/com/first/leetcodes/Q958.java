package com.first.leetcodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q958 {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;
        List<TreeNode> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = getDepth(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode tmp = queue.poll();
                if (level == depth - 1) {
                    if (tmp.left != null) {
                        queue.offer(tmp.left);
                        ans.add(tmp.left);
                    } else ans.add(null);
                    if (tmp.right != null) {
                        queue.offer(tmp.right);
                        ans.add(tmp.right);
                    } else ans.add(null);
                } else {
                    if (tmp.left != null) {
                        queue.offer(tmp.left);
                    }
                    if (tmp.right != null) {
                        queue.offer(tmp.right);
                    }
                }
            }
            level++;
        }
        if (ans.size() == 0) return false;
        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i) == null) {
                for (int j = i; j < ans.size(); j++) {
                    if (ans.get(j) != null) return false;
                }
            }
        }
        return true;
    }

    public int getDepth(TreeNode root) {
        return root == null ? 0 : Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        Q958 solution = new Q958();
        System.out.println(solution.isCompleteTree(node1));
    }
}

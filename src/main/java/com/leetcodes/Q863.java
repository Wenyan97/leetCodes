package com.leetcodes;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 */
public class Q863 {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        int targetLevel = 0;
        int tmpLevel = 0;
        if (root == null) return new ArrayList<>();
        if (root.val == target.val) targetLevel = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            tmpLevel++;
            for (int i = 0; i < length; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.val == target.val) {
                    targetLevel = tmpLevel;
                }
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
        }
    }

    /*public void helper(TreeNode root, TreeNode target, int K, int tmpK) {
        int targetLevel = 0;
        if (root.val == target.val) targetLevel = 1;

    }*/
}

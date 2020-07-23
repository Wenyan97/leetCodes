package com.leetcode.Tree.BST;

import com.datastructures.ListNode;
import com.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        getArrFromBST(root, list);
        return list.get(k - 1);
    }

    public void getArrFromBST(TreeNode root, List<Integer> list) {
        if (root == null) return;
        getArrFromBST(root.left, list);
        list.add(root.val);
        getArrFromBST(root.right, list);
    }
}

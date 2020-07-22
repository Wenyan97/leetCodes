package com.leetcode.Tree.BST;

import com.datastructures.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);

    }

    public TreeNode helper(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int rootIndex = (start + end) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = helper(nums, start, rootIndex - 1);
        root.right = helper(nums, rootIndex + 1, end);
        return root;
    }
}

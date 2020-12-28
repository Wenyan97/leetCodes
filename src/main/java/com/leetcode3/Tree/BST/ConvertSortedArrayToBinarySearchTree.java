package com.leetcode3.Tree.BST;

import java.util.Arrays;

import com.datastructures.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int len = nums.length;
        int rootIndex = len / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, rootIndex));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, rootIndex + 1, len));
        return root;
    }
    
}

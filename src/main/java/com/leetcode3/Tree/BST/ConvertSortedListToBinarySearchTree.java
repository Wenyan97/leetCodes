package com.leetcode3.Tree.BST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.datastructures.ListNode;
import com.datastructures.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        int i = 0;
        int len = getLength(head);
        int[] nums = new int[len];
        while (p != null) {
            nums[i] = p.val;
            p = p.next;
            i++;
        }
        return sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int len = nums.length;
        int rootIndex = len / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, rootIndex));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, rootIndex + 1, len));
        return root;
    }

    public int getLength(ListNode head) {
        int len = 0;
        if (head == null) return len;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        return len;
    } 
}

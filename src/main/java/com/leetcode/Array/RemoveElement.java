package com.leetcode.Array;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                for (int j = i; j < len; j++) {
                    nums[j] = nums[j + 1];
                }
                len--;
            }
            i--;
        }
        return len;
    }
}

package com.leetcode250;

import java.util.List;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        if (nums == null || nums.length == 0) {
            return null;
        }
        for (int i = 0; i < index.length - 1; i++) {
            for (int j = i + 1; j < index.length; j++) {
                if (nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[3];
        TwoSum solution = new TwoSum();
        solution.twoSum(nums, 6);
    }
    
}

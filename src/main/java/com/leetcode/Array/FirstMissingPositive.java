package com.leetcode.Array;

import java.util.Arrays;


public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int missNumber = 1;
        int end = nums.length - 1;
        for (int i = 0; i <= end; i++) {
            if (nums[i] == missNumber) {
                missNumber++;
            } else if (nums[i] > missNumber) {
                return missNumber;
            }
        }
        return missNumber;
    }
}

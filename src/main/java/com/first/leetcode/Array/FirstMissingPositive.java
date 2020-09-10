package com.first.leetcode.Array;

import java.util.Arrays;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 */
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

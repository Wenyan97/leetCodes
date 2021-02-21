package com.leetcode3.DP;

import java.util.Arrays;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] dp = Arrays.copyOf(nums, len);
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int[] dp = Arrays.copyOf(nums, nums.length);;
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }
    }
}

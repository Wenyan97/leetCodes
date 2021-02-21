package com.leetcode3.DP;

import java.util.Arrays;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] dp = Arrays.copyOf(nums, len);
        for (int i = 1; i < len; i++) {
            if (nums[i] * dp[i - 1] > 0) {
                dp[i] = nums[i] * dp[i - 1];
            } else {
                dp[i] = Math.max(dp[i], dp[i - 1] * nums[i]);
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        MaximumProductSubarray solution = new MaximumProductSubarray();
        System.out.println(solution.maxProduct(nums));
    }
}

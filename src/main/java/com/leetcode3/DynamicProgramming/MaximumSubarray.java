package com.leetcode3.DynamicProgramming;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;       
        if (n == 0) return 0;
        // base case
        int[] dp = new int[n];
        dp[0] = nums[0];
        // 状态转移方程
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-3, 4, -1, 2, -6, 1, 4};
        MaximumSubarray solution = new MaximumSubarray();
        System.out.println(solution.maxSubArray(nums));
    }
}

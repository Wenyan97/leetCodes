package com;

import java.util.Arrays;

public class Test {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }

        for (int i = 1; i < dp.length; i++) {
            
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + nums[i]);
        }
        return Arrays.stream(dp).max().orElseThrow();
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Test solution = new Test();
        System.out.println(solution.maxSubArray(nums));
    }
    
}

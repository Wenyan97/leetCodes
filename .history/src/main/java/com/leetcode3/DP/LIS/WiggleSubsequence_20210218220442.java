package com.leetcode3.DP.LIS;

import java.util.Arrays;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        boolean flag = true; // true: positive; false: negative
        for (int i = 0; i < len; i++) {
            if (flag == true) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] - nums[j] > 0) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        
                    }
                }
                flag = false;    
            } else {
                for (int j = 0; j < i; j++) {
                    if (nums[i] - nums[j] < 0) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }  
                flag = true;  
            }
            
        }
        return Arrays.stream(dp).max().orElse(0);
    }

    public static void main(String[] args) {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        WiggleSubsequence solution = new WiggleSubsequence();
        System.out.println(solution.wiggleMaxLength(nums));
    }
}

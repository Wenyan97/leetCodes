package com.leetcode3.DynamicProgramming;

import java.util.Arrays;

public class HouseRobberII {
    public int rob(int[] nums) {
       int len = nums.length;
       if (len == 0) {
           return 0;
       }
       if (len == 1) {
        return nums[0];
        }
       return Math.max(myRob(Arrays.copyOfRange(nums, 0, len - 1)), myRob(Arrays.copyOfRange(nums, 1, len)));
    }

    public int myRob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (i == 1) {
                dp[i] = Math.max(dp[0], nums[i]);
            } else {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
        }
        return nums[len - 1];
    }
}

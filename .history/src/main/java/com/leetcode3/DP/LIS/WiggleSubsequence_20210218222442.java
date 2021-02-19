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
        for (int i = 1; i < len; i++) {
            flag = true;
            for (int j = 0; j < i; j++) {
                if ((nums[i] > nums[j] && flag == true) || (nums[i] < nums[j] && flag == false)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    flag = flag == true ? false : true;
                } else dp[i] = dp[j];
            }
        }
        return Arrays.stream(dp).max().orElse(0);
    }

    public static void main(String[] args) {
        // int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int[] nums = (1, 7, 4, 9, 2, 5);
        WiggleSubsequence solution = new WiggleSubsequence();
        System.out.println(solution.wiggleMaxLength(nums));
    }
}

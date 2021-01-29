package com.leetcode3.DynamicProgramming;



public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 最坏情况：dp[i] = 1 + 1 + ... + 1
            dp[i] = i;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares solution = new PerfectSquares();
        System.out.println(solution.numSquares(12));
    }
}

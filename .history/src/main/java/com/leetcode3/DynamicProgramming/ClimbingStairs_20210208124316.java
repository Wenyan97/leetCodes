package com.leetcode3.DynamicProgramming;

import java.util.Arrays;

/**
 * You are climbing a staircase. It takes n steps to reach the top.

 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    /* public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        memo[1] = 1;
        return dp(n, memo);
    }

    public int dp(int n, int[] memo) {
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = dp(n - 1, memo) + dp(n - 2, memo);
        return memo[n];
    } */

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        System.out.println(solution.climbStairs(2));
    }
}

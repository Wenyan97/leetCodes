package com.first.leetcode.DynamicProgramming;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
//        if (n == 1) return 1;
//        if (n == 2) return 2;
//        return climbStairs(n - 1) + climbStairs(n - 2);
        int[] num = new int[n + 1];
        num[0] = 1;
        num[1] = 1;

        for (int i = 2; i < num.length; i++) {
            num[i] = num[i - 1] + num[i - 2];
        }
        return num[n];
    }

    public static void main(String[] args) {
        ClimbingStairs so = new ClimbingStairs();
        System.out.println(so.climbStairs(4));
    }
}

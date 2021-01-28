package com.leetcode3.DynamicProgramming;

/**
 * You are climbing a staircase. It takes n steps to reach the top.

 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        System.out.println(solution.climbStairs(4));
    }
}

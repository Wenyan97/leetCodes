package com.leetcode3.DynamicProgramming;

import java.util.Arrays;

public class PaintHouse {
    public int minCost(int[][] costs) {
        // write your code here
        int len = costs.length;
        int[] dp = new int[len];
        int pre = 0;
        dp[0] = costs[0][0];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == pre) continue;
                dp[i] = Math.min(dp[i] + costs[i][j], dp[i]);
                pre = i;
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        int[][] costs = {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
        PaintHouse solution = new PaintHouse();
        System.out.println(solution.minCost(costs));
    }
}

package com.leetcode3.DynamicProgramming;

import java.util.Arrays;

public class PaintHouse {
    public int minCost(int[][] costs) {
        // write your code here
        int len = costs.length;
        int[] dp = new int[len];
        int pre = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == pre) continue;
                dp[i] = Math.min(dp[i - 1] + costs[i][j], dp[i - 1]);
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

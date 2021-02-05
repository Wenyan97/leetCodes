package com.leetcode3.DynamicProgramming;

import java.util.Arrays;

public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        
        int n = costs.length;
        int[][] f = new int[n][3]; 
        //f[i][j] = min(f[i - 1][0...j - 1, j+1 ... 3]) + cost[i][j];
        
        for (int i = 0; i < 3; i++) {
            f[0][i] = costs[0][i]; 
        }
        
        for (int i = 1; i < n; i++) { //从第二个房子开始
            for (int j = 0; j < 3; j++) {//分别把房子刷成0,1,2三种颜色
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (k == j) {
                        continue;
                    }
                    min = Math.min(f[i - 1][k], min); 
                }
                f[i][j] = min + costs[i][j];
            }
        }
        
        //刷完所有房子后打擂台求出最小花费
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            res = Math.min(res, f[n - 1][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] costs = {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
        PaintHouse solution = new PaintHouse();
        System.out.println(solution.minCost(costs));
    }
}

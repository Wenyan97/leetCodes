package com.first.leetcode.DynamicProgramming;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m + 1][n + 1];
        if (m == 1 || n == 1) return 1;
//        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        for (int i = 0; i < n + 1; i++) {
            path[1][i] = 1;
        }
        for (int i = 0; i < m + 1; i++) {
            path[i][1] = 1;
        }
        for (int i = 2; i < m + 1; i++) {
            for (int j = 2; j < n + 1; j++) {
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }
        return path[m][n];
    }

    public static void main(String[] args) {
        UniquePaths so = new UniquePaths();
        System.out.println(so.uniquePaths(3, 3));
    }
}

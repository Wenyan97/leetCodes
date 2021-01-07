package com.leetcode3.DFSandBFS;

public class MaxAreaOfIsland {
    int maxArea = 0;
    int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                    area = 0;
                }
            }
        }
        return maxArea;
    }

    public void dfs(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c) || grid[r][c] == 0) return;
        grid[r][c] = 0;//已经访问过了
        this.area++;
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    public boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}

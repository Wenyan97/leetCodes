package com.leetcode3.DFSandBFS;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int r, int c) {
        if (!inArea(grid, r, c) || grid[r][c] == '0') return;
        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    public boolean inArea(char[][] grid, int r, int c) {
        return (r >= 0 && r < grid.length) && (c >= 0 && c < grid[0].length);
    }

    public static void main(String[] args) {
        System.out.println(1111);
    }
}


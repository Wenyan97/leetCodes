package com.leetcode3.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[j].length; j++) {
                if (dfs(matrix, i, j, Integer.MAX_VALUE)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public boolean dfs(int[][] matrix, int r, int c, int pre) {
        if (isPacific(matrix, r, c) && isAtlantic(matrix, r, c)) {
            return true;
        }
        if (matrix[r][c] > pre && !isAtlantic(matrix, r, c) && isPacific(matrix, r, c)) {
            return false;
        } 
        return dfs(matrix, r + 1, c, matrix[r][c]) || dfs(matrix, r - 1, c, matrix[r][c]) || dfs(matrix, r, c + 1, matrix[r][c]) || dfs(matrix, r, c - 1, matrix[r][c]);
    }

    public boolean isPacific(int[][] matrix, int r, int c){
        return r < 0 || c < 0;
    }

    public boolean isAtlantic(int[][] matrix, int r, int c) {
        return r >= matrix.length || c >= matrix[0].length;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        PacificAtlanticWaterFlow solution = new PacificAtlanticWaterFlow();
        solution.pacificAtlantic(matrix);
    }
}

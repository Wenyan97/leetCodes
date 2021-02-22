package com.leetcode3.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[j].length; j++) {
                if (dfs(matrix, i, j)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public boolean dfs(int[][] matrix, int r, int c) {
        if (isPacific(matrix, r, c) && isAtlantic(matrix, r, c)) {
            return true;
        }
        dfs(matrix, r + 1, c);
        dfs(matrix, r - 1, c);
        dfs(matrix, r, c + 1);
        dfs(matrix, r, c - 1);
        return false;
    }

    public boolean isPacific(int[][] matrix, int r, int c){
        return r < 0 || c < 0;
    }

    public boolean isAtlantic(int[][] matrix, int r, int c) {
        return r >= matrix.length || c >= matrix[0].length;
    }


    public static void main(String[] args) {
        
    }
}

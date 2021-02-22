package com.leetcode3.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dfs1(matrix, i, j, Long.MAX_VALUE) && dfs2(matrix, i, j, Long.MAX_VALUE)) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    public boolean dfs1(int[][] matrix, int r, int c, long pre) {
        if(r > matrix.length-1 || r > matrix[0].length-1 || matrix[r][c] == -1 || matrix[r][c] > pre){
            return false;
        }
        if (r <= 0 || c <= 0) {
            return true;
        }
        int temp = matrix[r][c];
        matrix[r][c] = -1;
        boolean b1 = dfs1(matrix, r + 1, c, temp);
        boolean b2 = dfs1(matrix, r - 1, c, temp);
        boolean b3 = dfs1(matrix, r, c + 1, temp);
        boolean b4 = dfs1(matrix, r, c - 1, temp);
        matrix[r][c] = temp;
        return b1 || b2 || b3 || b4;
    }

    public boolean dfs2(int[][] matrix, int r, int c,  long pre) {
        if(r < 0 || c < 0 || matrix[r][c] == -1 ||  matrix[r][c] > pre){
            return false;
        }
        if (r >= matrix.length-1 || c >= matrix[0].length-1) {
            return true;
        }
        int temp = matrix[r][c];
        matrix[r][c] = -1;
        boolean b1 = dfs2(matrix, r + 1, c, temp);
        boolean b2 = dfs2(matrix, r - 1, c, temp);
        boolean b3 = dfs2(matrix, r, c + 1, temp);
        boolean b4 = dfs2(matrix, r, c - 1, temp);
        matrix[r][c] = temp;
        return b1 || b2 || b3 || b4;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        PacificAtlanticWaterFlow solution = new PacificAtlanticWaterFlow();
        solution.pacificAtlantic(matrix);
    }
}

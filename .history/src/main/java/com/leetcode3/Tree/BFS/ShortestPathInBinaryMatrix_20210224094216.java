package com.leetcode3.Tree.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int shortLen = 0;
        if (grid == null || grid.length == 0) {
            return shortLen;
        }
        q.offer(grid[0][0]);
        visited.add(grid[0][0]);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int temp = new        
            }
        }
    }
}

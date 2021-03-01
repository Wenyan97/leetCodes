package com.leetcode250;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n];
    
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
            
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(visited, i, adjList);
            }
        }
        return count;
    }
    
    private void dfs(boolean[] visited, int index, List<List<Integer>> adjList) {
        visited[index] = true;
        for (int i : adjList.get(index)) {
            if (!visited[i]) {
                dfs(visited, i, adjList);
            }
        }
    }
    
    public static void main(String[] args) {
        int n = 5;
        int[][] edges ={{0,1}, {1,2}, {3,4}};
        NumberOfConnectedComponentsInAnUndirectedGraph so = new NumberOfConnectedComponentsInAnUndirectedGraph();
        so.countComponents(n, edges);
        System.out.println(n);
    }
}

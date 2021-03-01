package com.leetcode250;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        return 0;

    }   
    

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1}, {1,2}, {3,4}};
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        // 无向图，所以需要添加双向引用
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                System.out.println(adj[i].get(j));
            }
        }
    }
}

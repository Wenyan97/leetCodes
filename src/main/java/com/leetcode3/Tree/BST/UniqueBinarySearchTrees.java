package com.leetcode3.Tree.BST;


public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 0;
        G[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                G[i] += G[i - 1] * G[i - j]; 
            }
        }
        return G[n];
    }
}

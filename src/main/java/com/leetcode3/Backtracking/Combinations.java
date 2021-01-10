package com.leetcode3.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) return ans;
        backtrack(n, k, new ArrayList<>(), 1);
        return ans;
    }

    public void backtrack(int n, int k, List<Integer> path, int start) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(n, k, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

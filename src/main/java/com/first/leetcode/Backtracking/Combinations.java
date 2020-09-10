package com.first.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0) return ans;
        backtrack(n, k, new ArrayList<>(), 1);
        return ans;
    }

    public void backtrack(int n, int k, ArrayList<Integer> path, int start) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = start; i <= n; i++) {
            //加入节点
            path.add(i);
            //回溯
            backtrack(n, k, path, i + 1);
            //删除节点
            path.remove(path.size() - 1);
        }
    }
}

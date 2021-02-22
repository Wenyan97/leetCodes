package com.leetcode3.backtracking2;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class Combinations {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) {
            return res;
        }
        backtracking(n, k, new ArrayList<>(), 1);
        return res;
    }

    public void backtracking(int n, int k, List<Integer> path, int start) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            backtracking(n, k, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

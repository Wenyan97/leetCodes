package com.leetcode3.Backtracking;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    /**
     * 
     * @param k : numbers
     * @param n: target
     */
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0 || n == 0) {
            return ans;
        }
        backtrack(k, n, new ArrayList<>(), 1);
        return ans;
    }

    public void backtrack(int k, int target, List<Integer> path, int start) {
        // 终止条件
        if (target == 0 && path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= 9; i++) {
            // 小于零则直接继续
            if (target - i < 0) continue;
            path.add(i);
            // 由于是每个数字只能用一次， start = i + 1
            backtrack(k, target - i, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

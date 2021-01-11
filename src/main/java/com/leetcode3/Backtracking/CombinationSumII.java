package com.leetcode3.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0 || target == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(), 0);
        return ans;
    }

    public void backtrack(int[] candidates, int target, List<Integer> path, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        } 
        for (int i = start; i < candidates.length; i++) {
            // 避免重复元素
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (target - candidates[i] < 0) continue;
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

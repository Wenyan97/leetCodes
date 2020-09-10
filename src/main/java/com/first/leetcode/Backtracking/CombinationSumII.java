package com.first.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) return ans;
        Arrays.sort(candidates);
        backtrack(candidates, new ArrayList<>(), target, 0);
        return ans;
    }

    public void backtrack(int[] candidates, ArrayList<Integer> path, int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
        } else if (target < 0) return;
        
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i  - 1]) continue;

            path.add(candidates[i]);

            backtrack(candidates, path, target - candidates[i], i + 1);

            path.remove(path.size() - 1);
        }
    }
}

package com.first.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return ans;
        backtrack(candidates, new ArrayList<>(), target, 0);
        return ans;
    }

    public void backtrack(int[] candidates, ArrayList<Integer> path,  int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
        } else if (target < 0) return;
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);

            backtrack(candidates, path, target - candidates[i], start);

            path.remove(path.size() - 1);
        }
    }
}

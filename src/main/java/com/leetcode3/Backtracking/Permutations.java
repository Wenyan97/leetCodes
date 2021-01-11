package com.leetcode3.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return ans;
        backtrack(nums, new ArrayList<>());
        return ans;
    }

    public void backtrack(int[] nums, List<Integer> path) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) continue;
            path.add(nums[i]);
            backtrack(nums, path);
            path.remove(path.size() - 1);
        }
    }
}

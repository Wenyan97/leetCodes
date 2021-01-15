package com.leetcode3.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return ans;
        }
        backtrack(nums, new ArrayList<>(), 0);
        return ans;
    }
    

    public void backtrack(int[] nums, List<Integer> path, int start) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, path, i);
            path.remove(path.size() - 1);
        }
    }
}

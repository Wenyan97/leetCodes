package com.leetcode3.Backtracking;

import java.util.*;

public class subsetsII {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            return ans;
        }
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), 0);
        return ans;
    }

    public void backtrack(int[] nums, ArrayList<Integer> path, int start) {
        ans.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtrack(nums, path, i + 1);
            path.remove(path.size() - 1);
        }
    }   
}

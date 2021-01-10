package com.leetcode3.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) return ans;
        backtrack(nums, new ArrayList<>(), 0);
        return ans;
    }

    public void backtrack(int[] nums, List<Integer> subset, int start) {
        ans.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        subsets solution = new subsets();
        List<List<Integer>> ans = solution.subsets(nums);
        System.out.println(ans);
    }
}
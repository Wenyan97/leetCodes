package com.leetcode3.backtracking2;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0){
            return res;
        }
        backtracking(nums, new ArrayList<>(), 0);
        return res;
        
    }

    public void backtracking(int[] nums, List<Integer> path, int start) {
        res.add(new ArrayList<>(path));
        for (int i = 0; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets solution = new Subsets();
        solution.subsets(nums);
    }

}

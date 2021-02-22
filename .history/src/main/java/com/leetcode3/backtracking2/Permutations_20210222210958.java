package com.leetcode3.backtracking2;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

    }

    public void backtracking(int[] nums, List<Integer> curr, int start) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
        }
        for (int i = 0; i < nums.length; i++) {
            if () {
                
            }
            curr.add(nums[i]);
            backtracking(nums, curr, i);
            curr.remove(curr.size() - 1);
        }
            
    }
}

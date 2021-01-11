package com.leetcode3.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

public class CombinationSum {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0 || target == 0) {
            return ans;
        }
        backtrack(candidates, target, new ArrayList<>());
        for (int i = 0; i < ans.size(); i++) {
            Collections.sort(ans.get(i));
        }
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < ans.size(); i++) {
            set.add(ans.get(i));
        }
        ans.clear();
        for (List<Integer> list : set) {
            ans.add(list);
        }
        return ans;
    }

    public void backtrack(int[] candidates, int target, List<Integer> path) {
        if (!path.isEmpty() && 0 == target) {
            ans.add(new ArrayList<>(path));
            return;
        } else if (target < 0) return;
        for (int i = 0; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> list = solution.combinationSum(nums, 7);
        System.out.println(1111);
    }
}

package com.leetcode.Backtracking;

import java.util.*;

public class PermutationsII {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) return ans;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            used[i] = false;
//        }
        backtrack(nums, new ArrayList<>(), used);
        return ans;
    }

    public void backtrack(int[] nums, List<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            //notes: 如果不加!used[i - 1]， 则1，1，2这种情况直接会被剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, path, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        PermutationsII so = new PermutationsII();
        int[] a = {1, 1, 2};
        so.permuteUnique(a);
        System.out.println(so.ans);
    }
}

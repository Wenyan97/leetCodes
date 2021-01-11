package com.leetcode3.Backtracking;

public class CombinationSumIV {
    int ans = 0;
    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0 || target == 0) return ans;
        backtrack(nums, target);
        return ans;
    }

    public void backtrack(int[] nums, int target) {
        if (target == 0) {
            ans++;
            return;
        }
        // 回溯
        for (int i = 0; i < nums.length; i++) {
            if (target < 0) continue;
            backtrack(nums, target - nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 32;
        CombinationSumIV solution = new CombinationSumIV();
        System.out.println(solution.combinationSum4(nums, target));

    }
}

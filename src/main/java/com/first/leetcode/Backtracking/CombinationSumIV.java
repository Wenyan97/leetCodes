package com.first.leetcode.Backtracking;

import java.util.HashMap;
import java.util.Map;

public class CombinationSumIV {
    int ans = 0;
    /*public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0) return 0;
        backtrack(nums, target, 0);
        return ans;
    }*/
    public int combinationSum4II(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        return backtrack(nums, target, map);
    }

    public int backtrack(int[] nums, int target, Map<Integer, Integer> map) {
        if (nums.length == 0) return 0;
        if (target == 0) return 1;
        int ans = 0;
        for (int num : nums) {
            if (num <= target) {
                if (map.containsKey(target)) {
                    ans += map.get(target - num);
                } else {
                    int tmpAns = backtrack(nums, target - num, map);
                    //memo 记录
                    map.put(target - num, tmpAns);
                    ans += tmpAns;
                }
            }
        }
        return ans;
    }

    /*public void backtrack(int[] nums, int target, int currSum) {
        if (nums.length == 0) return;
        if (currSum == target) {
            ans++;
            return;
        } else if (currSum > target) return;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            backtrack(nums, target, currSum);
            currSum -= nums[i];
        }
    }*/

    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
        CombinationSumIV so = new CombinationSumIV();
        System.out.println(so.combinationSum4II(nums, 4));
    }
}

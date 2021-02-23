package com.leetcode3.backtracking2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null && nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        backtrack(nums, new ArrayList<>(), visited);
        return res;
    }

    public void backtrack(int[] nums, List<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true || (i >= 1 && nums[i] == nums[i - 1] && !visited[i])) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            backtrack(nums, path, visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        PermutationsII solution = new PermutationsII();
        solution.permuteUnique(nums);
    }
}

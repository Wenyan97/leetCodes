package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n <= 0) return ans;
        backtrack(k, n, new ArrayList<>(), 1, 0);
        return ans;
    }

    public void backtrack(int count, int target, ArrayList<Integer> path, int start, int currCount) {
        if (currCount == count) {
            if (target == 0) {
                ans.add(new ArrayList<>(path));
            } else if (target < 0) {
                return;
            }
        } else if (currCount > count) return;
        for (int i = start; i <= 9; i++) {
            path.add(i);
            currCount++;
            backtrack(count, target - i, path, i + 1, currCount);
            currCount--;
            path.remove(path.size() - 1);
        }
    }

    public void backtrack(int count, int target, ArrayList<Integer> path, int start) {
        if (count == 0) {
            if (target == 0) {
                ans.add(new ArrayList<>(path));
            } else if (target < 0) {
                return;
            }
        } else if (count < 0) return;
        for (int i = start; i <= 9; i++) {
            path.add(i);
            backtrack(count--, target - i, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumIII so = new CombinationSumIII();
        so.combinationSum3(3, 7);
        System.out.println(so.ans);
    }
}

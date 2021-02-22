package com.leetcode3.backtracking2;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 
 * 说明：
 * 
 * 所有数字都是正整数。 解集不能包含重复的组合
 * 
 * 输入: k = 3, n = 7
    输出: [[1,2,4]]
 * 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0 || n == 0) {
            return res;
        }
        backtracking(k, n, new ArrayList<>(), 0, 1, 9 - k + 1);
        return res;
    }

    public void backtracking(int k, int n, List<Integer> path, int sum,  int start, int end) {
        if (path.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(path));
            }
            return;
        }  
        for (int i = start; i <= end; i++) {
            path.add(i);
            backtracking(k, n, path, sum + i, i + 1, end + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumIII solution = new CombinationSumIII();
        solution.combinationSum3(3, 9);
    }
}

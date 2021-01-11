package com.leetcode3.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    /**
     * @param n: a integer
     * @return: return a 2D array
     */
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> getFactors(int n) {
        // write your code here
        if (n == 0) return ans;
        backtrack(n, new ArrayList<>(), 2);
        //去除n本身
        ans.remove(ans.size() - 1);
        return ans;
    }

    public void backtrack(int n, List<Integer> path, int start) {
        if (n == 1) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < n; i++) {
            if (n % i != 0) continue;
            path.add(i);
            backtrack(n / i, path, i);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        FactorCombinations solution = new FactorCombinations();
        List<List<Integer>> list = solution.getFactors(32);
        System.out.println("2323");
    }
}

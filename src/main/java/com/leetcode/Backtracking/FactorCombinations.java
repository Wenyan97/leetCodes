package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *Numbers can be regarded as product of its factors. For example,
 *
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 */
public class FactorCombinations {
    List<List<Integer>> ans =  new ArrayList<>();
    public List<List<Integer>> getFactors(int n) {
        // write your code here
        if (n == 0) return ans;
        backtrack2(n, new ArrayList<>(), 1, 2);
        return ans;
    }

    public void backtrack2(int sum, ArrayList<Integer> path, int curr, int start) {
//        if(start > sum || curr > sum ) return;
        if (curr == sum) {
            ans.add(new ArrayList<>(path));
        } else if (curr > sum) return;
        for (int i = start; i <= sum / 2; i++) {
            if(i * curr > sum) break;
            if (sum % i == 0) {
                path.add(i);
//                curr *= i;
                backtrack2(sum, path, curr * i, i);
//                curr /= i;
                path.remove(path.size() - 1);
            }
        }
    }


    public void backtrack(int sum, ArrayList<Integer> path, int n, int reminder) {
        if (n == 1 ) {
            if (reminder == 0) {
                ans.add(new ArrayList<>(path));
            }
            return;
        } else if (n == 0) return;
        for (int i = 2; i <= sum / 2 ; i++) {
            if (n % i == 0) {
                path.add(i);
                reminder = n % i;
                n = n / i;
                backtrack(sum, path, n, reminder);
                n *= i;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        FactorCombinations so = new FactorCombinations();
        so.getFactors(8192);
        System.out.println(so.ans);
    }

}

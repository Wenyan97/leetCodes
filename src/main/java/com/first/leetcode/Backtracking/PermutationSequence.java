package com.first.leetcode.Backtracking;


/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 */
public class PermutationSequence {
    int curr = 0;
    String ans;
    public String getPermutation(int n, int k) {
        if (n == 0) return null;
        backtrack(new StringBuilder(""), n, k, 0, new boolean[n + 1]);
        return ans;
    }

    public void backtrack(StringBuilder str, int n, int k, int count, boolean[] used) {
        if (count == n) {
            curr++;
            if (curr == k) {
                ans =  str.toString();
            }
        }
        if (count > n) return;
        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                str.append(i);
                used[i] = true;
                backtrack(str, n, k,count + 1, used);
                used[i] = false;
                str.deleteCharAt(str.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PermutationSequence so = new PermutationSequence();
        String str = so.getPermutation(3, 6);
        System.out.println(str);
    }
}

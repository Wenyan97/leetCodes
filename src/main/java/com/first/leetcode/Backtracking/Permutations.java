package com.first.leetcode.Backtracking;

import java.util.*;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class Permutations {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return ans;
        backtrack(nums, new ArrayList<>(), new HashSet<>());
        return ans;
    }

    //distinct可以用boolean used[i] 代替
    public void backtrack(int[] nums, List<Integer> path, Set<Integer> distinct) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
        }
        for (int num : nums) {
            if (!distinct.contains(num)) {
                path.add(num);
                //set用于判断是否重复
                distinct.add(num);
                backtrack(nums, path, distinct);
                //删除元素
                path.remove(path.size() - 1);
                distinct.remove(num);
            }
        }
    }


    public static void main(String[] args) {
        Permutations so = new Permutations();
        int[] a = {1, 2, 3};
        so.permute(a);
        System.out.println(so.ans);
    }
}

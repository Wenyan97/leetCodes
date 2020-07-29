package com.leetcode.Backtracking;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<>();
        backtrack(nums, new LinkedList<>(), 0);
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track, int start) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            //选择
            track.add(nums[i]);
            //回溯
            backtrack(nums, track, i + 1);
            //撤销选择
            track.removeLast();
        }
    }
}

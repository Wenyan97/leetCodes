package com.leetcode3;

import java.util.Arrays;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int i = 0;
        if (len == 1) return nums[0];
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[len - 1] != nums[len - 2]) {
            return nums[len - 1];
        }
        for (i = 1; i < len - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String arg[]) {
        int[] nums = {4,1,2,1,2};
        SingleNumber solution = new SingleNumber();
        System.out.println(solution.singleNumber(nums)); 
    }
}

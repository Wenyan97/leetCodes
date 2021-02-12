package com.leetcode3.DynamicProgramming;

public class HouseRobber {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (i == 1) {
                dp[i] = Math.max(dp[0], nums[i]);
            } else {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
        }
        return dp[len - 1];
    }
    
    /* public int maxi(int[] a, int l, int r) {
        if (r - l == 0) {
            return a[r];
        }
        int lmax = maxi(a, l, (l + r) / 2);
        int rmax = maxi(a, (l + r) / 2 + 1, r);
        System.out.println(lmax + " " + rmax);
        if (rmax < lmax) {
            return lmax;
        } else return rmax;
    }

    public static void main(String[] args) {
        int[] a = {10, 8, 6, 4, 2};
        HouseRobber solution = new HouseRobber();
        solution.maxi(a, 0, 4);

    } */
}

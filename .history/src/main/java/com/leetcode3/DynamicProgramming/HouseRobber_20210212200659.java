package com.leetcode3.DynamicProgramming;

public class HouseRobber {
    public int rob(int[] nums) {
        int count = Integer.MIN_VALUE;
        if (nums.length == 1) {
            return nums[0];
        }

        
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

package com.first.leetcodes.arrayLearning;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 */
public class Q1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ansNum = new int[m + n];
        int pm = 0, pn = 0;
        for (int i = 0; i < ansNum.length; i++) {
            if (nums1[pm] <= nums2[pn] && nums1[pm] != 0 ) {
                ansNum[i] = nums1[pm];
                pm++;
            } else {
                ansNum[i] = nums2[pn];
                pn++;
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = ansNum[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {};
        Q1 solution = new Q1();
        solution.merge(nums1, 1, nums2, 0);
        System.out.println(Arrays.toString(nums1));
    }
}

package com.leetcode250;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        return search(nums, 0, nums.length, target);
    }

    public int search(int[] nums, int head, int tail, int target) {
        if (head > tail) return 0;
        if (head == tail) return nums[head];
        int mid = (head + tail) / 2;
        if (target == nums[mid]) return nums[mid];
        if (target < nums[mid]) {
            return search(nums, head, tail, target);
        }
        if (target > nums[mid]) {
            return search(nums, mid + 1, tail, target);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        System.out.println(solution.search(nums, 0));
    }
}

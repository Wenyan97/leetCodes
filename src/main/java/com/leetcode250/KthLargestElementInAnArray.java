package com.leetcode250;

import java.util.HashMap;
import java.util.Map;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        buildHeap(nums);
        for (int i = 1, j = nums.length; i <= k; i++, j--) {
            swap(nums, 0, nums[j]);
            maxHeapify(nums, 0);
        }
        return nums[0];
    }


    public void maxHeapify(int[] a, int i) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        int heapSize = a.length;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        } 
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest);
        }
    }

    public void buildHeap (int[] nums) {
        int len = nums.length;
        for (int i = len / 2; i >= 0; --i) {
            maxHeapify(nums, i);
        }
    }


    public void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> windows = new HashMap<>();
        int left = 0, right = 0;
        int res = Integer.MIN_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            while (windows.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                windows.put(c, windows.get(d) - 1);
            }
            res = Math.max(res, left - right);
        }   
        return res;
    }

    
}

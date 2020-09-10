package com.first.leetcode.Array;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        // Initialize the counter and the second pointer.
        int i = 1, count = 1;
        // Start from the second element of the array and process
        // elements one by one.
        for (int j = 1; j < nums.length; j++) {
            // If the current element is a duplicate, increment the count.
            if (nums[j] == nums[j - 1]) {
                count++;
            } else {
                // Reset the count since we encountered a different element
                // than the previous one.
                count = 1;
            }
            // For a count <= 2, we copy the element over thus
            // overwriting the element at index "j" in the array
            if (count <= 2) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}

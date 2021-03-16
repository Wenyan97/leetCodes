package com;

import java.util.Arrays;

import com.datastructures.ListNode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 

示例 1：

输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。


 */
public class Test {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }

        for (int i = 1; i < dp.length; i++) {
            
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // dp[i] = Math.max(dp[i], nums[i]);
        }
        return Arrays.stream(dp).max().orElseThrow();
    }


    
    
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head, next = head.next;
        while (next != null) {
            if (curr.val != next.val) {
                curr = curr.next;
                next = next.next;
            } else {
                curr.next = next.next;
                next = next.next; 
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Test solution = new Test();
        System.out.println(solution.maxSubArray(nums));
    }
    
}

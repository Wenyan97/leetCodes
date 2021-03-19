package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



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


    
    
    // public ListNode deleteDuplicates(ListNode head) {
    //     if (head == null || head.next == null) return head;
    //     ListNode curr = head, next = head.next;
    //     while (next != null) {
    //         if (curr.val != next.val) {
    //             curr = curr.next;
    //             next = next.next;
    //         } else {
    //             curr.next = next.next;
    //             next = next.next; 
    //         }
    //     }
    //     return head;
    // }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums != null && nums.length < 3) return res;
        Arrays.sort(nums);
        int length = nums.length;
        int i = 0;
        while (i < length) {
            if (nums[i] > 0) return res;
            int left = i + 1;
            int right = length - 1;
            if (nums[i] + nums[left] + nums[right] == 0) {
                res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                while (left < length && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (right > 0 && nums[right] == nums[right - 1]) {
                    right--;
                }   
                left++;
                right--;
            } else if (nums[i] + nums[left] + nums[right] < 0) {
                left++;
            } else {
                right--;
            }
            
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int a = Arrays.stream(nums).max().getAsInt();
        Test solution = new Test();
        System.out.println(solution.maxSubArray(nums));
        System.out.println(1 / 2);
    }
    
}

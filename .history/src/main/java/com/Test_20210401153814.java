package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



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

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;
        int nums = matrix.length * matrix[0].length;
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
        while (nums > 0) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
                nums--;
            }
            up++;
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
                nums--;
            }
            right--;
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
                nums--;
            }
            down--;
            for (int i = down; i >= up; i--) {
                list.add(matrix[i][left]);
                nums--;
            }
            left++;
        }
        return list;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = Arrays.copyOf(nums1, m);
        int p1 = 0, p2 = 0;
        int p = 0;
        while (p1 < m && p2 < n) {
            if (nums1Copy[p1] < nums2[p2]) {
                nums1[p] = nums1Copy[p1];
                p1++;

            } else {
                nums1[p] = nums2[p2];
                p2++;
            }
            p++;
        }

        if (p1 < m) System.arraycopy(nums1Copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n) System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }


    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // intialzition
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
 
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;   
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + 1;
            }
        }
        return dp[m - 1][n - 1];
    }


    int index = 0;

    public String[] permutation(String s) {
        boolean[] visited = new boolean[s.length()];
        String[] strRes = new String[getPermutationNum(s.length())];
        if (s == null || s.length() == 0) return null;
        dfs(strRes, visited, s, new StringBuilder(""));
        return strRes;
    }

    public void dfs(String[] strRes, boolean[] visited, String s, StringBuilder sb) {
        if (sb.length() == s.length()) {
            strRes[index++] = new StringBuilder(sb).toString();
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i >= 0 && visited[i] == true) continue;
            if (i >= 1 && s.charAt(i) == s.charAt(i - 1)) continue;
            sb.append(s.charAt(i));
            visited[i] = true;
            dfs(strRes, visited, s, sb);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }

    public int getPermutationNum(int len) {
        if (len == 1) return 1;
        return len * getPermutationNum(len - 1);
    }
    public static void main(String[] args) {
        Test so = new Test();
        String s = "abc";
        so.permutation(s);
        
    }
    
}

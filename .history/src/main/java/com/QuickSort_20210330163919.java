package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QuickSort {
    

    
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> windows = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        int count = 0; // at least equals to 1
        while(right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (!windows.containsKey(c)) {
                count = 0;
                windows.put(c, ++count);
            } else windows.put(c, windows.get(c) + 1);  
            while (windows.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                windows.put(d, windows.get(d) - 1);
            } 
            res = Math.max(res, right - left);
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            char r = s.charAt(i);
            if (r >= 'a' && r <= 'z') {
                sb.append(r);
            }
            if (r >= 'A' && r <= 'Z') {
                sb.append(r);
            }
        }
        String str = sb.toString().toLowerCase();
        // System.out.println(str);
        int length = sb.length();
        // even
        if (length % 2 == 0) {
            int l = sb.length() / 2 - 1;
            int r = l + 1;
            while (l >= 0 && r < str.length()) {
                if (str.charAt(l) != str.charAt(r)) return false;
                l--; r++;
            }
        } else {
            int l = sb.length() / 2 - 1;
            int r = l + 2;
            while (l >= 0 && r < str.length()) {
                if (str.charAt(l) != str.charAt(r)) return false;
                l--; r++;
            }
        }
        return true;
            
    }


    public int f(int N) {
        // write your code in Java SE 11
        int L = 0;
        // sum is the summation of this arthmetic sequence 
        int sum = (1 + L) * L / 2;
        while (sum <= N) {
            L++;
            sum = (1 + L) * L / 2;
        }
        return L - 1;
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        
        for (int i = 1; i < len + 1; i++) {
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);
                if (dp[j] && dict.contains(str)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];

    }

    public int funcf(int n) {
        if (n == 0 ) {
            return 0;
        } else if(n > 0) {
            return funcf(n - 1) + n;
        }
        return n;
    }

    public int f(int N) {
        // write your code in Java SE 11
        int L = 0;
        // sum is the summation of this arthmetic sequence 
        int sum = (1 + L) * L / 2;
        while (sum <= N) {
            L++;
            sum = (1 + L) * L / 2;
        }
        return L - 1;
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix[0], target);
        if (row < matrix.length) binarySearch(matrix[row], target);
        return false;
    }

    public int findRow(int[] nums, int target) {
        int top = 0, bottom = nums.length - 1;

        while (top < bottom) {
            int mid = (bottom - top) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                top = mid + 1;
            } else {
                bottom = mid - 1;
            }
        }
        return top;
    }

    public boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
    

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        // System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        // System.out.println(solution.isPalindrome("0P"));
        // System.out.println(solution.)

        int[] a = {{1, 3}};
        System.out.println( solution.binarySearch(a, 3));
       
       
    }

}

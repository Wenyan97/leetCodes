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


    public int solution(int N) {
        // write your code in Java SE 11
        int i = 0;
        while ()
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


    

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        // System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        // System.out.println(solution.isPalindrome("0P"));
        String s = "leetcode";
        List<String> word = Arrays.asList("leet", "code");
        solution.wordBreak(s, word);
    }

}

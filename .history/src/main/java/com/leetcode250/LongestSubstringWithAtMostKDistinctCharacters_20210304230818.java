package com.leetcode250;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> windows = new HashMap<>();
        int right = 0, left = 0;
        int count = 0;
        int res = Integer.MIN_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (!windows.containsKey(c)) {
                windows.put(c, 1);  
            } else windows.put(c, windows.get(c) + 1);
            int size = windows.size();
            while (size > k) {
                res = Math.min(res, left - right - 1);
                char d = s.charAt(left);
                left++;
                if (windows.containsKey(d)) {
                    windows.put(d, windows.get(d) - 1);
                }
            }
            
        }
        return res;
    }   

    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctCharacters so = new LongestSubstringWithAtMostKDistinctCharacters();
        System.out.println(so.lengthOfLongestSubstringKDistinct("eceba", 2));
    }
}

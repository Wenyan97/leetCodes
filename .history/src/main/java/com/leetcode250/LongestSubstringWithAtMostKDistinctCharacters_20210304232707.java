package com.leetcode250;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> windows = new HashMap<>();
        int right = 0, left = 0;
        int res = Integer.MIN_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            int count = windows.getOrDefault(c, 0);
            windows.put(c, count + 1);
            int size = windows.size();
            while (size > k) {
                char d = s.charAt(left);
                windows.put(d, windows.get(d) - 1);
                if (windows.get(d) == 0) {
                    windows.remove(d);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }   

    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctCharacters so = new LongestSubstringWithAtMostKDistinctCharacters();
        System.out.println(so.lengthOfLongestSubstringKDistinct("eceba", 2));
    }
}

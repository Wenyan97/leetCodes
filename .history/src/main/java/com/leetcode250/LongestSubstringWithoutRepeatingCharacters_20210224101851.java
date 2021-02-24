package com.leetcode250;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int p = 0, q = 0; // two pointers;
        List<Character> list = new ArrayList<>();
        while (p != s.length() && q != s.length()) {
            if (!list.contains(s.charAt(q))) {
                list.add(s.charAt(q));
                q++;
            } else {
                max = Math.max(max, list.size());
                list.clear();
                p = q;
            }          
        }
        max = Math.max(max, list.size());
        return max;
    }

    public static void main(String[] args) {
        String s = " ";
        LongestSubstringWithoutRepeatingCharacters so = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(so.lengthOfLongestSubstring(s));
    }
}

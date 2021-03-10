package com.leetcode250;

import java.util.HashMap;
import java.util.Map;

/**
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
示例 1:

输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LongestSubstringWithoutRepeatingCharacters2 {
    public int lengthOfLongestSubstring(String s) {
        int max = 1;
        if (s == null || s.length() == 0) return max;
        Map<Character, Integer> windows = new HashMap<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            while (windows.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                windows.put(d, windows.get(d) - 1);
            }
            max = Math.max(max, right - left);
        }
        return max;

    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters2 solu = new LongestSubstringWithoutRepeatingCharacters2();
        solu.lengthOfLongestSubstring("abcabcbb");
    }
}

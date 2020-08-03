package com.leetcode.Backtracking;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    Map<Integer, String> map = new HashMap<>();
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) return ans;
        initMap(map);
        List<String> list = new ArrayList<>();
        backtrack(list, 0, new StringBuilder(), digits);
        return ans;
    }

    public void backtrack(List<String> list, int start, StringBuilder sb, String digits) {
        if (start == digits.length()) {
            ans.add(sb.toString());
        } else {
            String tmp = map.get(digits.charAt(start) - '0');
            for (int i = 0; i < tmp.length(); i++) {
                sb.append(tmp.charAt(i));
                backtrack(list, start + 1, sb, digits);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }


    public void initMap(Map<Integer, String> map) {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber so = new LetterCombinationsOfAPhoneNumber();
        List<String> list = so.letterCombinations("23");
        System.out.println("wewe");
    }

}

package com.leetcode250;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<>() {{
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuilder());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuilder path) {
        if (index == digits.length()) {
            combinations.add(path.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        int letterLength = letters.length();
        for (int i = 0; i < letterLength; i++) {
            path.append(letters.charAt(i));
            backtrack(combinations, phoneMap, digits, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        int[] num = {1, 3, 5};
    }
}

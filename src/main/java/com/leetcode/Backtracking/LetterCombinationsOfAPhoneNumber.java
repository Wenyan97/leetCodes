package com.leetcode.Backtracking;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    Map<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        initMap(map);
        List<String> list = new ArrayList<>();
        int count = digits.length();
        for (int i = 0; i < count; i++) {
            list.add(map.get(digits.charAt(i)));
        }
        return list;
    }

    public void initMap(Map<Character, String> map) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber so = new LetterCombinationsOfAPhoneNumber();
        List<String> list = so.letterCombinations("23");
        System.out.println("wewe");
    }

}

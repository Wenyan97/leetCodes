package com.first.leetcodes;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * @author PC_YWY
 */
public class Q17 {
    public List<String> letterCombinations(String digits) {

        Map<String, String> digitLetterMap = new HashMap<>();
        digitLetterMap.put("2", "abc");
        digitLetterMap.put("3", "def");
        digitLetterMap.put("4", "ghi");
        digitLetterMap.put("5", "jkl");
        digitLetterMap.put("6", "mno");
        digitLetterMap.put("7", "pqrs");
        digitLetterMap.put("8", "tuv");
        digitLetterMap.put("9", "wxyz");
        List<String> ansArr = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            ansArr.add(digitLetterMap.get(String.valueOf(digits.charAt(i))));
        }
//        System.out.println(ansArr);
        List<String> result = new ArrayList<>();
        if (digits.length() == 1 ) {
            String ans = digitLetterMap.get(digits);
            for (int i = 0; i < ans.length(); i++) {
                result.add(String.valueOf(ans.charAt(i)));
            }
            return result;
        }
        return null;
    }

    public List<String> twoArrCombinations(String arr1, String arr2) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr1.length(); i++) {
            for (int j = 0; j < arr2.length(); j++) {
                String temp = String.valueOf(arr1.charAt(i));
                temp += String.valueOf(arr2.charAt(j));
                result.add(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q17 solution = new Q17();
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        System.out.println('2' - '0');
        System.out.println(map['2' - '0']);
    }
}

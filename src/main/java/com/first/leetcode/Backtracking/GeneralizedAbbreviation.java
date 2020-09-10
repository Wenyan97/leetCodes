package com.first.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.(order does not matter)
 *
 * 样例
 * Example 1:
 *
 * Input:
 * word = "word",
 * Output:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */
public class GeneralizedAbbreviation {
    List<String> res = new ArrayList<>();
    public List<String> generateAbbreviations(String word) {
        // Write your code here
        backtrack(word, 0, new StringBuilder(word));
        List<String> fin = new ArrayList<>();
        for (String re : res) {
            String str = merge(re);
            fin.add(str);
        }
        return fin;
    }

    //回溯得到11o11, 11111类似的数组
    public void backtrack(String word, int start, StringBuilder sb) {
        res.add(sb.toString());
        for (int i = start; i < word.length(); i++) {
            sb.setCharAt(i, '1');
            backtrack(word, i + 1, sb);
            sb.setCharAt(i, word.charAt(i));
        }
    }

    //将11o11->202, 11111->5
    public String merge(String str) {
        StringBuilder str1 = new StringBuilder(str);
        StringBuilder ans = new StringBuilder();
        int i = 0, count = 0, j = 0;
        while (j < str.length()) {
            if (str1.charAt(i) != '1') {
                ans.append(str1.charAt(i));
                i++;
                j = i;
            } else {
                while (j < str.length() && str1.charAt(j) == '1') {
                    count++;
                    j++;
                }
                i = j;
                ans.append(count);
                count = 0;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        GeneralizedAbbreviation so = new GeneralizedAbbreviation();
        List<String> list = so.generateAbbreviations("word");
        String str  = so.merge("111o11");
        System.out.println("dd");
    }
}

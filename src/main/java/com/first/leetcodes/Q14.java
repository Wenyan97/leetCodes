package com.first.leetcodes;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * @author PC_YWY
 */
public class Q14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        //按照字符串长度进行升序排序，以第一项为基准进行判断
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        StringBuilder str = new StringBuilder("");
        boolean flag = false;
        for (int j = 0; j < strs[0].length(); j++) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(j) == strs[0].charAt(j)) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                str.append(strs[0].charAt(j));
            } else {
                break;
            }
        }
//        if (flag) {
//            return str.toString();
//        } else {
//            return "";
//        }
        return str.toString();
    }

    public static void main(String[] args) {
        Q14 solution = new Q14();
        String ans = solution.longestCommonPrefix(new String[]{"aa", "a"});
        System.out.println(ans);
    }
}

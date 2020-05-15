package com.leetcodes;
/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author alllen
 */

public class Q3 {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 1;
        int length = 1;
        boolean isDeal = false;
        if (s.equals("")){
            return 0;
        }
        for (int i = 0; i < s.length() - 1; i++){
            for (int j = i + 1; j < s.length(); j++){
                for (int x = i; x < j; x++){
                    if (s.charAt(j) != s.charAt(x)){
                       length++;
                    } else {
                        isDeal = true;
                        break;
                    }
                }
                if (isDeal){
                    isDeal = false;
                    length = 1;
                    break;
                }
                if (maxLength <= length){
                    maxLength = length;
                }
                length = 1;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) throws Exception {
        Q3 q3 = new Q3();
        String str = "abcabcdabfhua";
        System.out.println(q3.lengthOfLongestSubstring(str));
    }
}




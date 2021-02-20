package com.leetcode3.DP;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        text1 = " " + text1;
        text2 = " " + text2;
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m ; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n ; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(text1.charAt(0));
        LongestCommonSubsequence solution = new LongestCommonSubsequence();
        System.out.println(solution.longestCommonSubsequence(text1, text2));
    }
}

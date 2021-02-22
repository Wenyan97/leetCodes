package com.leetcode3.Backtracking;

public class WordSearch {
    StringBuilder sb = new StringBuilder("");
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    int expectedSearchTimes = word.length();
                    dfs(board, i, j, new StringBuilder(""), expectedSearchTimes);
                    if (sb.toString().equals(word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void dfs(char[][] board, int r, int c, StringBuilder curr, int expectedSearchTimes) {
        if (inArea(board, r, c)) {
            curr.append(board[r][c]);
            if (expectedSearchTimes == 1) {
                sb = curr;
                curr.deleteCharAt(curr.length() - 1);
                return;
            } else {
                dfs(board, r + 1, c, curr, expectedSearchTimes - 1);
                dfs(board, r - 1, c, curr, expectedSearchTimes - 1);
                dfs(board, r, c + 1, curr, expectedSearchTimes - 1);
                dfs(board, r, c, curr, expectedSearchTimes - 1);
                curr.deleteCharAt(curr.length() - 1);
            }   
        }
    }

    public boolean inArea(char[][] board, int r, int c) {
        return r >= 0 && r < board.length && c >= 0 && c < board[0].length;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        WordSearch solution = new WordSearch();
        System.out.println(solution.exist(board, "SEE"));
    }
}

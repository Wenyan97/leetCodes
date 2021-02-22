package com.leetcode3.Backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordSearch {
    
    Set<StringBuilder> set = new HashSet<>();
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    int expectedSearchTimes = word.length();
                    dfs(board, i, j, new StringBuilder(""), expectedSearchTimes,visited);
                    if (set.contains(new StringBuilder(word))) {
                        return true;
                    }
                    set.clear();
                }
            }
        }
        return false;
    }

    public void dfs(char[][] board, int r, int c, StringBuilder curr, int expectedSearchTimes, boolean[][] visited) {
        if (inArea(board, r, c)) {
            curr.append(board[r][c]);
            if (expectedSearchTimes == 1) {
                set.add(curr);
                curr.deleteCharAt(curr.length() - 1);
                return;
            } else {
                dfs(board, r + 1, c, curr, expectedSearchTimes - 1, visited);
                dfs(board, r - 1, c, curr, expectedSearchTimes - 1, visited);
                dfs(board, r, c + 1, curr, expectedSearchTimes - 1, visited);
                dfs(board, r, c - 1, curr, expectedSearchTimes - 1, visited);
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

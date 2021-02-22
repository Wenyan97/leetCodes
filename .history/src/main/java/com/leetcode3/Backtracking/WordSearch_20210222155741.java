package com.leetcode3.Backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.datastructures.ListNode;

public class WordSearch {
    
    Set<String> set = new HashSet<>();
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
                    if (set.contains(word)) {
                        return true;
                    }
                }
                set.clear();
            }
        }
        return false;
    }

    public void dfs(char[][] board, int r, int c, StringBuilder curr, int expectedSearchTimes, boolean[][] visited) {
        if (inArea(board, r, c)) {
            if (!visited[r][c]) {
                curr.append(board[r][c]);
                visited[r][c] = true;
                if (expectedSearchTimes == 1) {
                    set.add(curr.toString());
                } else {
                    dfs(board, r + 1, c, curr, expectedSearchTimes - 1, visited);
                    dfs(board, r - 1, c, curr, expectedSearchTimes - 1, visited);
                    dfs(board, r, c + 1, curr, expectedSearchTimes - 1, visited);
                    dfs(board, r, c - 1, curr, expectedSearchTimes - 1, visited);                   
                }  
                curr.deleteCharAt(curr.length() - 1);
                visited[r][c] = false;
            }
        }
    }

    public boolean inArea(char[][] board, int r, int c) {
        return r >= 0 && r < board.length && c >= 0 && c < board[0].length;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        WordSearch solution = new WordSearch();
        System.out.println(solution.exist(board, "ABCCED"));
    }
}



/* public boolean exist(char[][] board, String word) {
    char[] words = word.toCharArray();
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            //从[i,j]这个坐标开始查找
            if (dfs(board, words, i, j, 0))
                return true;
        }
    }
    return false;
}

boolean dfs(char[][] board, char[] word, int i, int j, int index) {
    //边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符，
    //如果这个字符不等于board[i][j]，说明验证这个坐标路径是走不通的，直接返回false
    if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index])
        return false;
    //如果word的每个字符都查找完了，直接返回true
    if (index == word.length - 1)
        return true;
    //把当前坐标的值保存下来，为了在最后复原
    char tmp = board[i][j];
    //然后修改当前坐标的值
    board[i][j] = '.';
    //走递归，沿着当前坐标的上下左右4个方向查找
    boolean res = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) ||
            dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1);
    //递归之后再把当前的坐标复原
    board[i][j] = tmp;
    return res;
}

 */
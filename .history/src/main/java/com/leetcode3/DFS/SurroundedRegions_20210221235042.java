package com.leetcode3.DFS;

public class SurroundedRegions {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || j == 0 || i == board.length || j == board[0].length) {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Z') {
                    board[i][j] = 'O';
                }
            }
        }
    }


    public void dfs(char[][] board, int r, int c) {
        if (!inArea(board, r, c) && board[r][c] == 'O') {
            return;
        }
        board[r][c] = 'Z';
        dfs(board, r - 1, c);
        dfs(board, r + 1, c);
        dfs(board, r, c - 1);
        dfs(board, r, c + 1);
    }


    public boolean inArea(char[][] board, int r, int c) {
        return r >=0 && r < board.length && c >= 0 && c < board[0].length;
    }

    public boolean inEdge(char[][] board, int r, int c) {
        return r == 0 || r == board.length || c == 0 || c == board[0].length;
    }

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'},
                        {'X', 'O', 'O', 'X'},
                        {'X', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'X'}};
        SurroundedRegions solution = new SurroundedRegions();
        solution.solve(board);
    }
}

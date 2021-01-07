package com.leetcode3.DFSandBFS;


/**
 * 2D网络为：
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
答案为：
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 */
public class WallsAndGates {
    static int INF = Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        // write your code here
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

 

    public void dfs(int[][] rooms, int r, int c, int currPath) {
        if (!inArea(rooms, r, c) || rooms[r][c] == -1) {
            return;
        }
        // 保证最小值
        if (rooms[r][c] > currPath || currPath == 0) {
            rooms[r][c] = currPath;
            dfs(rooms, r + 1, c, currPath + 1);
            dfs(rooms, r - 1, c, currPath + 1);
            dfs(rooms, r, c + 1, currPath + 1);
            dfs(rooms, r, c - 1, currPath + 1);
        }
    }

    public boolean inArea(int[][] rooms, int r, int c) {
        return r >= 0 && r < rooms.length && c >= 0 && c < rooms[0].length;
    }

    public static void main(String[] args) {
        int[][] rooms = {{INF, -1, 0, INF},
                         {INF, INF, INF, -1},
                         {INF, -1, INF, -1},
                         {0, -1, INF, INF}};
        WallsAndGates solution = new WallsAndGates();
        solution.wallsAndGates(rooms);
        System.out.println("helloworld");
    }
}

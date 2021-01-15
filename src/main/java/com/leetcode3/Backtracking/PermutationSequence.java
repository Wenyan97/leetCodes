package com.leetcode3.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationSequence {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int index = 1;
    public String getPermutation(int n, int k) {
        String ans = new String();
        if (n == 0 || k == 0) {
            return ans;
        }
        dfs(n, new ArrayList<>(), 1);
        List<Integer> ansPath = map.get(k);
        ans = ansPath.toString();
        return ans;
    }

    public void dfs(int n, List<Integer> path, int start) {
        if (path.size() == n)  {
            map.put(++index, new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (path.contains(i)) {
                continue;
            }
            path.add(i);
            dfs(n, path, i);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        PermutationSequence solution = new PermutationSequence();
        System.out.println(solution.getPermutation(3, 3));
    }


}

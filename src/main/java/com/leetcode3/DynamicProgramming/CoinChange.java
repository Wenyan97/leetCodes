package com.leetcode3.DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    // public int coinChange(int[] coins, int amount) {
    //     int[] dp = new int[amount + 1];

    //     Arrays.fill(dp, amount + 1);
    //     dp[0] = 0;
    //     for (int i = 1; i <= amount; i++) {
    //         for (int coin : coins) {
    //             if (i - coin >= 0 && i - coin != amount + 1) {
    //                 dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
    //             }
    //         }
    //     }

    //     return dp[amount] == amount + 1 ? -1 : dp[amount];
    // }


    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        Arrays.sort(coins);
        return dfs(coins, amount, memo);
    }

    private int dfs(int[] coins, int amount, int[] memo) {
        int res = Integer.MAX_VALUE;
        if (amount == 0) {
            return 0;
        }

        if (memo[amount] != -2) {
            return memo[amount];
        }

        for (int coin : coins) {
            if (amount - coin < 0) {
                break;
            }
            int subRes = dfs(coins, amount - coin, memo);
            if (subRes == -1) {
                continue;
            }
            res = Math.min(res, subRes + 1);
        }
        return memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
    }

}

package com.leet_code;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Collections;

public class LC_322_Coin_Change {
    public static void run() {
        out.println(coinChange(new int[] { 1, 2, 5 }, 11)); // 3
        out.println(coinChange(new int[] { 2 }, 3));        // -1
        out.println(coinChange(new int[] { 186, 419, 83, 408 }, 6249));        //6249
    }

    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

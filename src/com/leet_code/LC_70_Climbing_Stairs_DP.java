package com.leet_code;

public class LC_70_Climbing_Stairs_DP {
    public static int climbStairs(int n) {
        final int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int index = 3; index <= n; index++) {
            dp[index] = dp[index - 1] + dp[index - 2];
        }
        return dp[n];
    }

    public static void run() {
        int i = climbStairs(3);
    }
}

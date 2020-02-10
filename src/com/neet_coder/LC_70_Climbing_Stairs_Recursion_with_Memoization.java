package com.neet_coder;

public class LC_70_Climbing_Stairs_Recursion_with_Memoization {
    //Timesout
    public static int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return helper(0, n, memo);
    }

    private static int helper(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }

        memo[i] = helper(i + 1, n, memo) + helper(i + 2, n, memo);
        return memo[n];
    }

    public static void run() {
        int i = climbStairs(5);
    }
}

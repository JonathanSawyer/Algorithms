package com.neet_coder;

public class LC_70_Climbing_Stairs_Recursion {
    //Timesout
    public static int climbStairs(int n) {
       return helper(0, n);
    }

    private static int helper(int i, int n) {
        if(i > n) {
            return 0;
        }
        if(i == n) {
            return 1;
        }

        return helper(i + 1, n) + helper(i + 2, n);
    }

    public static void run() {
        int i = climbStairs(5);
    }
}

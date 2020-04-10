package com.leet_code;

public class LC_70_Climbing_Stairs_Fib {
    public static int climbStairs(int n) {
        int step1 = 0;
        int step2 = 1;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = step1 + step2;
            step1 = step2;
            step2 = result;
        }
        return result;
    }

    public static void run() {
        int i = climbStairs(5);
    }
}

package com.leet_code;

import java.util.HashSet;

public class LC_202_Happy_Number {
    //    Input: 19
//    Output: true
//    Explanation:
//      12 + 92 = 82
//      82 + 22 = 68
//      62 + 82 = 100
//      12 + 02 + 02 = 1
    public static void run() {
        boolean happy = isHappy(20);
    }

    public static boolean isHappy(int n) {
        final int[] squares = { 0, 1, 4, 9, 16, 25, 36, 49, 64, 81 };
        HashSet set = new HashSet();
        while (true) {
            int ans = 0;
            while (n > 0) {
                ans += squares[n % 10];
                n /= 10;
            }
            if (ans == 1) {
                return true;
            } else {
                n = ans;
                if (set.contains(n)) {
                    return false;
                }
                set.add(n);
            }
        }
    }

//    Floyd's Cycle-Finding Algorithm
//    public int getNext(int n) {
//        int totalSum = 0;
//        while (n > 0) {
//            int d = n % 10;
//            n = n / 10;
//            totalSum += d * d;
//        }
//        return totalSum;
//    }
//
//    public boolean isHappy(int n) {
//        int slowRunner = n;
//        int fastRunner = getNext(n);
//        while (fastRunner != 1 && slowRunner != fastRunner) {
//            slowRunner = getNext(slowRunner);
//            fastRunner = getNext(getNext(fastRunner));
//        }
//        return fastRunner == 1;
//    }
}

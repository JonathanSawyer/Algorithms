package com.neet_coder;

public class LC_69_Sqrt_x {
    public static void run() {
        int i = mySqrt(100);
    }

    public static int mySqrt(int x) {

        int times = 0;
        while (2 <= x) {
            x /= 2;
            times++;
        }
        return times;
    }
}
// 1    1
// 4    2
// 9    3
// 16   4
// 25   5
// 36   6
// 49   7
// 64   8
// 81   9
//100   10


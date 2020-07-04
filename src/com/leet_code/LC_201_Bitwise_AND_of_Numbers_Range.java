package com.leet_code;

public class LC_201_Bitwise_AND_of_Numbers_Range {
    public static void run() {
        int i = rangeBitwiseAnd(5, 7);
    }

    public static int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        for(int newValue = m; m <= n; m++) {
            result = newValue & m;
        }
        return result;
    }
}

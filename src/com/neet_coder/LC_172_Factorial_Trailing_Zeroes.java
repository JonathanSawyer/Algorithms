package com.neet_coder;

public class LC_172_Factorial_Trailing_Zeroes {
//    Input: 3
//    Output: 0
//    Explanation: 3! = 6, no trailing zero.

//    Input: 5
//    Output: 1
//    Explanation: 5! = 120, one trailing zero.

    public static void run() {
        int i = trailingZeroes(100);
        }

    public static int trailingZeroes(int n) {
        if (n / 5 == 0) return 0;
        return n / 5 + trailingZeroes(n / 5);
    }

    //naive approach
//    public static int trailingZeroes(int n) {
//        long factorial = calculateFactorial(n);
//        int mod = 0;
//        int trailingZeros = 0;
//        while (mod == 0) {
//            mod = (int) (factorial % 10);
//            if(mod == 0) {
//                trailingZeros++;
//            }
//            factorial /= 10;
//        }
//        return trailingZeros;
//    }
//
//    public static long calculateFactorial(int n) {
//        long fact = 1;
//        for (int i = 2; i <= n; i++) {
//            fact = i * fact;
//        }
//        return fact;
//    }
}

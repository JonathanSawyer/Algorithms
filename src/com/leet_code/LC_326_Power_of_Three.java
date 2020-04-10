package com.leet_code;

public class LC_326_Power_of_Three {
   public static void run() {
       final boolean powerOfThree = isPowerOfThree(27);// true
   }

    public static boolean isPowerOfThree(int n) {
        if(n < 1) {
            return false;
        }

        while(n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}

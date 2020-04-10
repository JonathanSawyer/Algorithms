package com.leet_code;

public class LC_1317_Convert_Integer_to_the_Sum_of_Two_No_Zero_Integers {
//    4102
//    111, 3991
    public static void run() {
        int[] noZeroIntegers1 = getNoZeroIntegers(11);
        int[] noZeroIntegers2 = getNoZeroIntegers(10000);
        int[] noZeroIntegers3 = getNoZeroIntegers(69);
        int[] noZeroIntegers4 = getNoZeroIntegers(4102);
    }

    public static int[] getNoZeroIntegers(int n) {
        int no1 = n - 1;
        while(no1 > 0){
            final int no2 = n - no1;
            if(containsZeroes(no1) || containsZeroes(no2)) {
                no1--;
                continue;
            }

            return new int[]{n - no1, no1};
        }
        return new int[0];
    }

    public static boolean containsZeroes(int n) {
        for(int i = n; i != 0; i /= 10) {
            if (i % 10 == 0) {
                return true;
            }
        }
        return false;
    }
}

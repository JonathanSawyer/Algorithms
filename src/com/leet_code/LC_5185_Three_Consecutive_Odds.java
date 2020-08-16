package com.leet_code;

public class LC_5185_Three_Consecutive_Odds {
    public static void main(String[] args) {
        System.out.println(threeConsecutiveOdds(new int[] { 1, 2, 34, 3, 4, 5, 7, 23, 12 }));
        System.out.println(threeConsecutiveOdds(new int[] { 2, 6, 4, 1, 3,5 }));
    }

    public static boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length < 3) {
            return false;
        }
        for(int i = 2; i < arr.length; i++) {
            final boolean b = isOdd(arr[i]) && isOdd(arr[i - 1]) && isOdd(arr[i - 2]);
            if(b) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOdd(int num) {
        return num % 2 != 0;
    }
}

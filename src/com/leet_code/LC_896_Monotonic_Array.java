package com.leet_code;

public class LC_896_Monotonic_Array {
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[] { 2, 2, 2, 3 }));
        System.out.println(isMonotonic(new int[] { 1, 2, 1}));
        System.out.println(isMonotonic(new int[] { 10, 1, 2}));
        System.out.println(isMonotonic(new int[] { }));
    }

    public static boolean isMonotonic(int[] s) {
        boolean increasing = false;
        boolean decreasing = false;

        int prev = s[0];
        for(int i = 1; i < s.length; i++) {
            int cur = s[i];
            if(cur == prev) {

            }
            else if(cur > prev) {
                increasing = true;
            }else {
                decreasing = true;
            }
            prev = cur;
            if(increasing && decreasing) {
                return false;
            }
        }
        return true;
    }
}

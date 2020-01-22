package com.neat_coder;

public class LC_334_Increasing_Triplet_Subsequence_2 {
    public static void run() {
        boolean b = increasingTriplet(new int[] { 5, 1, 5, 5, 2, 5, 4 });
    }

    private static boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for(int num : nums) {
            if(num <= small) {
                small = num;
            }else if(num <= big) {
                big = num;
            }else {
                return true;
            }
        }
        return false;
    }
}

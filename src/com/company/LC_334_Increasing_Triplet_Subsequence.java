package com.company;

public class LC_334_Increasing_Triplet_Subsequence {
    public static void run() {
        boolean b = increasingTriplet(new int[] { 5, 1, 5, 5, 2, 5, 4 });
    }

    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {return false;}
        boolean dirtyNo1 = false;
        boolean dirtyNo2 = false;
        boolean dirtyNo3 = false;

        int no1 = Integer.MAX_VALUE;
        int no2 = Integer.MAX_VALUE;
        int no3 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            if (num <= no1) {
                no1 = nums[i];
                dirtyNo1 = true;
            } else if (num <= no2) {
                no2 = nums[i];
                dirtyNo2 = true;
            } else if (num <= no3) {
                no3 = nums[i];
                dirtyNo3 = true;
            }
            if (dirtyNo1 && dirtyNo2 && dirtyNo3) {
                if (no1 < no2 && no2 < no3) {
                    return true;
                }
            }
        }
        return false;
    }
}

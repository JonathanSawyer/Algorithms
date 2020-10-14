package com.leet_code;

import java.util.Arrays;

public class LC_1480_Running_Sum_of_1d_Array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[]{3,1,2,10,1})));
    }

    public static int[] runningSum(int[] nums) {
        final int[] res = new int[nums.length];
        for (int j = 1, numsLength = nums.length; j < numsLength; j++) {
            nums[j] += nums[j - 1];
        }
        return res;
    }
}

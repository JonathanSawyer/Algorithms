package com.leet_code.biweekly_53;

import java.util.Arrays;

public class P_5755 {
    public static void main(String[] args) {
        System.out.println(minPairSum(new int[] { 3,5}));
    }

    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0x80000000;
        for (int i = 0, n = nums.length - 1; i < n; i++, n--) {
            final int i1 = nums[i] + nums[n];
            if(i1 > max) {
                max = i1;
            }
        }
        return max;
    }
}

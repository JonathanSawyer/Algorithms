package com.leet_code;

import java.util.Arrays;

public class LC_5797 {
    public static void main(String[] args) {
        System.out.println(maxProductDifference(new int[] {4,2,5,9,7,4,8}));
    }

    public static int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n - 1] * nums[n-2]) - (nums[0] * nums[1]);
    }
}

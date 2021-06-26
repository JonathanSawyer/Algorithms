package com.leet_code;

import java.util.Random;

public class LC_169 {
    public static void main(String[] args) {

    }

    public static int majorityElement(int[] nums) {
        Random r = new Random();
        while (true) {
            int majorityCandidate = nums[r.nextInt(nums.length)];
            int count = 0;
            for (int num : nums) {
                if (num == majorityCandidate && ++count > nums.length / 2) {
                    return num;
                }
            }
        }
    }
}

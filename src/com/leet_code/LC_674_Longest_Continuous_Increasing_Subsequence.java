package com.leet_code;

public class LC_674_Longest_Continuous_Increasing_Subsequence {
    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[] { 2, 2, 3, 3, 3, 3 }));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int sum = 1;
        int runningSum = 1;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < nums[i + 1]) {
                runningSum++;
                if(runningSum > sum) {
                    sum = runningSum ;
                }
            }else {
                runningSum = 1;
            }
        }
        return sum;
    }
}

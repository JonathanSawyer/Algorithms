package com.company;

public class LC_198_House_Robber {
    public static void run() {
       // int rob1 = rob(new int[] { 1, 2, 3, 1});
        int rob2 = rob(new int[] { 2,7,9,3,1 }); //12
    }

    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}

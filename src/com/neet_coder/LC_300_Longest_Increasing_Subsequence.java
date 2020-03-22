package com.neet_coder;

import java.util.Arrays;

public class LC_300_Longest_Increasing_Subsequence {
//  Input: [10,9,2,5,3,7,101,18]
//  Output: 4
//  Explanation: The longest increasing subsequence
//               is [2,3,7,101], therefore the length is 4.
// 10 9 2 5 9 3 4 5
// 1  1 1 2 3 2 3 4

    public static void run() {
        int total = lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 });
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int currDpIdx = 0;
        int maxResult = 0;
        while (currDpIdx < nums.length) {
            for (int x = 0; x < currDpIdx; x++) {
                if (nums[x] > nums[currDpIdx]) {
                    dp[currDpIdx] = Math.max(dp[currDpIdx], dp[x] + 1);
                    if (dp[currDpIdx] > maxResult) {
                        maxResult = dp[currDpIdx];
                    }
                }
            }
            currDpIdx++;
        }
        return maxResult;
    }
}

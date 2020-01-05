package com.company;

public class LC_121_Best_Time_to_Buy_and_Sell_Stock_Recursion_with_DP {
    public static int maxProfit(int[] prices) {
        return recurse(prices, 0, new Integer[prices.length]);
    }


    // 2 cases -> we buy today or we skip today
    public static int recurse(int[]prices, int start, Integer[] dp) {
        if(start == prices.length) {
            return 0;
        }

        if(dp[start] != null) {
            return dp[start];
        }

        int skip = recurse(prices, start + 1, dp);

        int trade = Integer.MIN_VALUE;
        for(int i = start + 1; i<prices.length; i++) {
            trade = Math.max(trade, prices[i] - prices[start]);
        }

        return dp[start] = Math.max(skip, trade);
    }

    // Check every combination
    // Buy and only sell next if
    // its less than current.
    //
    // base case
    // prices.length <= 1 return 0

    public static void run() {
        int i = maxProfit(new int[] { 7, 1, 5, 3, 6, 4 });
    }
}

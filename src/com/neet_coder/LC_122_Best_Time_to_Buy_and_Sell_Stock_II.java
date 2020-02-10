package com.neet_coder;

public class LC_122_Best_Time_to_Buy_and_Sell_Stock_II {
    public static void run() {
        final int maxProfit = maxProfit(new int[] { 7, 1, 5, 3, 6, 4 });
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int sum = prices[i + 1] - prices[i];
            if (sum > 0) {
                maxProfit += sum;
            }
        }
        return maxProfit;
    }
}

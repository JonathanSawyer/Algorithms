package com.leet_code;

public class LC_121_Best_Time_to_Buy_and_Sell_Stock_Brute_Force {

    public static void run() {
        int i = maxProfit(new int[] { 7, 1, 5, 3, 6, 4 });
    }

    private static int maxProfit(int[] stock) {
        int max = 0;
        for(int index = 0; index < stock.length - 1; index++) {
            for(int indexInner = index + 1; indexInner < stock.length; indexInner++) {
                final int trade = stock[indexInner] - stock[index];
                if(trade > max) {
                    max = trade;
                }
            }
        }
        return max;
    }
}

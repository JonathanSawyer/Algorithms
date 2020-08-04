package com.leet_code;

public class LC_121_Best_Time_to_Buy_and_Sell_Stock_DP_One_Pass {
    public static void main(String[] args) {

    }
    public static void run() {
        int i = maxProfit(new int[] { 7, 1, 5, 3, 6, 4 });
    }

    private static int maxProfit(int[] stock) {
        int max = 0;
        for(int index = 0; index < stock.length - 1; index++) {
            int min = Integer.MAX_VALUE;
            int profit = 0;
            int price = stock[index];
            if(price < min) {
                min = price;
            }else if((price - min) > profit) {
                profit = price - min;
            }
            return profit;
        }
        return max;
    }
}

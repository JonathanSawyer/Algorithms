package com.leet_code;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_322_Coin_Change {
    public static void run() {
        out.println(coinChange(new int[] { 1, 2, 5 }, 11)); // 3
        out.println(coinChange(new int[] { 2 }, 3));        // -1
        out.println(coinChange(new int[] { 186, 419, 83, 408 }, 6249));        //6249
    }

    public static int coinChange(int[] coins, int amount) {
        int min = Integer.MAX_VALUE;
        List<Integer> coinsReverse = new ArrayList<>();
        for (int coin : coins) { coinsReverse.add(coin); }
        Collections.sort(coinsReverse, Collections.reverseOrder());

        int tempAmount = amount;
        int tempMin = 0;
        for (int i = 0; i < coinsReverse.size(); i++) {
            int coin = coinsReverse.get(i);
            while (tempAmount > 0) {
                tempAmount -= coin;
                tempMin++;
            }
            if (tempAmount == 0) {
                min = Math.min(tempMin, min);
                tempAmount = amount;
            } else {
                tempAmount += coin;
                tempMin--;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
}

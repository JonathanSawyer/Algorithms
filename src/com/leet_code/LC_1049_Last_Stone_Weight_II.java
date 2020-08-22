package com.leet_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_1049_Last_Stone_Weight_II {
    public static void main(String[] args) {
        System.out.println(lastStoneWeightII(new int[] { 2,1,1,1 }));
    }

    public static int lastStoneWeightII(int[] stones) {
        List<Integer> a = new ArrayList<>();
        for (int i : stones) {
            a.add(i);
        }
        Collections.sort(a, Collections.reverseOrder());

        int[] dp = new int[stones.length];
        for (int i = 0; i < a.size() - 1; i++) {
            dp[i] = dp[i] + a.get(i) - a.get(i + 1);
        }
        return dp[stones.length - 3];
    }
}

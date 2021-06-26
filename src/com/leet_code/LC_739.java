package com.leet_code;

import java.util.Arrays;

public class LC_739 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));
                                                                       //[1,  1,  4,  2,  1,  1, 0,  0]
        // System.out.println(Arrays.toString(dailyTemperatures(new int[] { 1, 3, 2, 2, 1 })));
        // 1,1,0,0
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i > 0; i--) {
            int a = temperatures[i - 1];
            int b = temperatures[i];

            if (a < b) {
                res[i - 1] = 1;
            } else {
                if(res[i] != 0) {
                    res[i - 1] = res[i] + 1;
                }
            }
        }
        return res;
    }
}


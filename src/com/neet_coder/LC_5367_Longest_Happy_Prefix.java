package com.neet_coder;

import java.util.Arrays;

public class LC_5367_Longest_Happy_Prefix {
    public static void run() {
        String ababab = longestPrefix("ababab");
    }

    public static String longestPrefix(String s) {
        final int length = s.length();
        final int[] dp = new int[length];
        Arrays.fill(dp,0);
        int index = 1;
        int maxLength = 0;
        while (index < length) {
            if (s.charAt(index) == s.charAt(maxLength)) {
                dp[index] = ++maxLength;
                index++;
            } else {
                if (maxLength != 0) {
                    maxLength = dp[maxLength - 1];
                } else {
                    index++;
                }
            }
        }
        return s.substring(0, dp[length - 1]);
    }
}

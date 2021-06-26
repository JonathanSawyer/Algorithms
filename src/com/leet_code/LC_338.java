package com.leet_code;

import java.util.Arrays;

public class LC_338 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(50)));
    }

    public static int[] countBits(int n) {
        int res[] = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }
}

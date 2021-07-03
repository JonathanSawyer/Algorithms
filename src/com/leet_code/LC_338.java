package com.leet_code;

import java.util.Arrays;

public class LC_338 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
    }

    public static int[] countBits(int n) {
        final int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = countSetBits(i);
        }
        return res;
    }

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}

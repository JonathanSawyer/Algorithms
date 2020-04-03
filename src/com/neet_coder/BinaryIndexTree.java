package com.neet_coder;

import java.util.Arrays;

public class BinaryIndexTree {
    public static void run() {
        int[] arr = { 3, 6, 2, 7, 5, 1, 4 };
        BIT bit = new BIT(arr.length + 1);
        for (int i = 0; i < arr.length; i++) {
            bit.add(i + 1, arr[i]);
            System.out.println(Arrays.toString(bit.bit));
        }
    }

    static class BIT {
        int[] bit;

        BIT(int n) {
            bit = new int[n + 1];
        }

        void add(int i, int val) {
            while (i < bit.length) {
                bit[i] += val;
                i += i & -i;
            }
        }

        int query(int i) {
            int ans = 0;
            while (i > 0) {
                ans += bit[i];
                i &= i - 1;
            }
            return ans;
        }
    }
}

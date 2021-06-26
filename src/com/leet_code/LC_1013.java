package com.leet_code;

import java.util.Arrays;

public class LC_1013 {
    public static void main(String[] args) {
        System.out.println(canThreePartsEqualSum(new int[] { 0, 0, 0, 0 }));
    }

    public static boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int i = sum / 3;
        int m = sum % 3;
        if (m != 0) {
            return false;
        }
        int cur = 0;
        int cnt = 0;
        for (int x : arr) {
            cur += x;
            if (cur == i) {
                cur = 0;
                cnt++;
            }
        }
        return cnt >= 3;
    }
}

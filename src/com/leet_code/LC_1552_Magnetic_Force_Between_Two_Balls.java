package com.leet_code;

import java.util.Arrays;

public class LC_1552_Magnetic_Force_Between_Two_Balls {
    public static void main(String[] args) {

    }

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 0, hi = (int) 1e9;
        while (lo < hi) {
            int mid = (lo + hi + 1) >>> 1;
            if (f(position, mid, m)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }

        }
        return lo;
    }

    private static boolean f(int[] position, int newNumberOfBalls, int numberOfBalls) {
        int matched = 1;
        int cur = position[0];
        for (int i = 0; i < position.length; i++) {
            if (position[i] - cur >= newNumberOfBalls) {
                cur = position[i];
                matched++;
            }
        }
        return matched >= numberOfBalls;
    }
}

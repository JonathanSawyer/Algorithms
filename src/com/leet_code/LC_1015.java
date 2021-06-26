package com.leet_code;

public class LC_1015 {
    public static void main(String[] args) {
        System.out.println(smallestRepunitDivByK((int) 18367));
    }

    public static int smallestRepunitDivByK(int k) {
        int remainder = 0;
        // Observation is that n will always be less than k
        for (int n = 1; n <= k; n++) {
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) {
                return n;
            }
        }
        return -1;
    }
}

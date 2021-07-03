package com.leet_code;

import java.util.HashSet;
import java.util.Set;

public class LC_1539 {
    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[] { 1, 2, 3, 4 }, 2));
    }

    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length + k;
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        for (int i = 0; i < n; i++) {
            if (!set.contains(i + 1)) {
                if (k == 1) {
                    return i + 1;
                } else {
                    k--;
                }
            }
        }
        return -1;
    }
}
//
// 2, 3, 4, 7, 11

//1 ... arr + k

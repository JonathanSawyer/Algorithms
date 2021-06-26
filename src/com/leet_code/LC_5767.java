package com.leet_code;

import java.util.HashSet;
import java.util.Set;

public class LC_5767 {
    public static void main(String[] args) {
        System.out.println(isCovered(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } }, 2, 5));
    }

    public static boolean isCovered(int[][] ranges, int left, int right) {
        Set<Integer> s = new HashSet<>();
        for (int x = left; x <= right; x++) {
            s.add(x);
        }
        for (int[] i : ranges) {
            int a = i[0];
            int b = i[1];
            for (int x = a; x <= b; x++) {
                s.remove(x);
            }
        }
        return s.isEmpty();
    }
}

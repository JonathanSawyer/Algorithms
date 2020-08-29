package com.leet_code;

import java.util.Arrays;

public class LC_977_Squares_of_a_Sorted_Array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[] { -4, -1, 0, 3, 10 })));
    }

    public static int[] sortedSquares(int[] A) {
        final int[] res = new int[A.length];
        for (int j = 0, aLength = A.length; j < aLength; j++) {
            int i = A[j] * A[j];
            res[j] = i;
        }
        Arrays.sort(res);
        return res;
    }
}

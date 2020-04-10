package com.leet_code;

import static java.lang.System.out;

import java.util.Arrays;

public class LC_240Search_a_2D_Matrix_II {
// Write an efficient algorithm that searches for a value in an m x n matrix.
// This matrix has the following properties:
// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.
// Consider the following matrix:
//
//            [
//            [1,   4,  7, 11, 15],
//            [2,   5,  8, 12, 19],
//            [3,   6,  9, 16, 22],
//            [10, 13, 14, 17, 24],
//            [18, 21, 23, 26, 30]
//            ]
//    Given target = 5, return true.
//    Given target = 20, return false.

    public static void run() {
        boolean b = searchMatrix(new int[][] { { 1, 4, 5, 7, 15 } }, 5);
        out.println(b);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = matrix.length - 1; i >= 0; i--) {
            int[] r = matrix[i];
            if (r.length == 0) {
                continue;
            }
            if (r[r.length - 1] == target) {
                return true;
            }
            if (target < r[r.length - 1]) {
//                out.println("here");
//                Arrays.stream(r).forEach(out::println);
//                out.println(Arrays.binarySearch(r, target));
                if (itemExists(r, target)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean itemExists(int[] a, int t) {
        if (a.length == 0) {
            return false;
        }
        int l = 0, r = a.length - 1;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] < t) {
                l = m + 1;
            } else if (a[m] > t) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}

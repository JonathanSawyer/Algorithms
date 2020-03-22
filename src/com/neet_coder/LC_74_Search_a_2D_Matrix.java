package com.neet_coder;

import java.util.Arrays;

// Write an efficient algorithm that searches for a value in an m x n matrix.
// This matrix has the following properties:
//
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
// Example 1:
//
// Input:
// matrix = [[1,   3,  5,  7],[10, 11, 16, 20],[23, 30, 34, 50]]
// target = 3
// Output: true
public class LC_74_Search_a_2D_Matrix {
    public static void run() {
        boolean b = searchMatrix(new int[][] { { 1, 3 } }, 3);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int[] matrix1 = matrix[binarySearchVertical(matrix, target)];
        final int binarySearch = Arrays.binarySearch(matrix1, target);
        return binarySearch >= 0;
    }

    public static int binarySearchVertical(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        while (start < end) {
            int mid = start + end >>> 1;
            int colVal = matrix[mid][matrix[0].length - 1];
            if (target > colVal) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static boolean binarySearch(int[] haystack, int needle) {
        int start = 0;
        int end = haystack.length - 1;

        while (start <= end) {
            int mid = start + end / 2;
            if (needle < haystack[mid]) {
                end = mid - 1;
            } else if (needle > haystack[mid]) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}

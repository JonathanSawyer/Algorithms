package com.leet_code;

public class LC_766_Toeplitz_Matrix {
    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][] { { 1, 2, 3, 4 }, { 5, 1, 2, 3 }, { 9, 5, 1, 2 } }));

//              [1,2,3,4]
//              [5,1,2,3]
//              [9,5,1,2]

    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                if (matrix[row][col] != matrix[row + 1][col + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}

package com.neet_coder;

public class LC_62_Unique_Paths {
    public static void run() {
        int maxPaths = uniquePaths(7, 3);
    }

    public static int uniquePaths(int m, int n) {
        int[][] matrix = new int[n][m];

        for (int col = 0; col < m; col++) {
            matrix[0][col] = 1;
        }

        for (int row = 1; row < n; row++) {
            matrix[row][0] = 1;
        }

        for (int col = 0; col < m - 1; col++) {
            for (int row = 0; row < n - 1; row++) {
                int total = matrix[row][col + 1] + matrix[row + 1][col];
                matrix[row + 1][col + 1] = total;
            }
        }
        return matrix[n - 1][ m - 1];
    }
}

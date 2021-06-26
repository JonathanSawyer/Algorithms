package com.leet_code.weekly_244;

public class LC_5776 {
    public static void main(String[] args) {

    }

    public boolean findRotation(int[][] mat, int[][] target) {
        if(areEqual(mat, target)) {return true;}
        for(int i = 0; i < 3; i++ ) {
            rotateMatrix(mat.length, mat);
            boolean equal = areEqual(mat, target);
            if(equal) {
                return true;
            }
        }
        return false;
    }

    static boolean areEqual(int[][] a, int[][] b) {
        int row1 = a.length;
        int row2 = b.length;
        int col1 = a[0].length;
        int col2 = b[0].length;
        if (row1 != row2 || col1 != col2) {
            return false;
        }
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void rotateMatrix(int N, int mat[][]) {
        for (int x = 0; x < N / 2; x++) {
            for (int y = x; y < N - x - 1; y++) {
                int temp = mat[x][y];
                mat[x][y] = mat[y][N - 1 - x];
                mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y];
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];
                mat[N - 1 - y][x] = temp;
            }
        }
    }
}

package com.leet_code;

public class LC_1582 {
    public static void main(String[] args) {
        System.out.println(numSpecial(new int[][]{
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 0, 0}}));


    }

    public static int numSpecial(int[][] mat) {
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if (mat[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int c = 0;
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if (mat[i][j] == 1) {
                    if (rows[i] == 1 && cols[j] == 1) c++;
                }
            }

        }
        return c;
    }
}

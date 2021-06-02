package com.leet_code.biweekly_53;

import java.util.ArrayList;
import java.util.Arrays;

public class P_5757 {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(getBiggestThree(new int[][] {
                        { 1, 2, 3 },
                        { 4, 5, 6 },
                        { 7, 8, 9 } })));
    }

    public static int[] getBiggestThree(int[][] grid) {
        for (int r = 0, gridLength = grid.length; r < gridLength; r++) {
            int[] row = grid[r];
            for (int c = 0, intsLength = row.length; c < intsLength; c++) {
                int sum = 0;
                int depth = c;
//                dfs(grid, r, c, depth, sum);
            }
        }
        return new int[]{};
    }
}

package com.leet_code;

public class LC_64_Minimum_Path_Sum {
    public static void run() {
        System.out.println(minPathSum(new int[][] {
                { 1, 2 },
                { 1, 1 }
        }));
    }

    public static int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int y = 0; y < grid[i].length; y++) {
                if (i == 0) {
                    if (y > 0) {
                        grid[i][y] += grid[i][y - 1];
                    }
                } else {
                    if (y != 0) {
                        grid[i][y] += Math.min(grid[i - 1][y], grid[i][y - 1]);
                    } else {
                        grid[i][y] += grid[i - 1][y];
                    }
                }
            }
        }
        return grid[grid.length - 1][grid[grid.length - 1].length - 1];
    }
}

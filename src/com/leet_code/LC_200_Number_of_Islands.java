package com.leet_code;

public class LC_200_Number_of_Islands {
    public static void run() {
        final char[][] grid1 = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };

        final char[][] grid2 = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };

        final int noIslands1 = numIslands(grid2);
        final int noIslands2 = numIslands(grid1);
    }

    static final int[][] MOVEMENTS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static int numIslands(char[][] grid) {
        int noIslands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    noIslands++;
                    convertIslandToSea(row, col, grid);
                }
            }
        }
        return noIslands;
    }

    public static void convertIslandToSea(int rowPos, int colPos, char[][] grid) {
        if (rowPos == -1
            || rowPos == grid.length
            || colPos == -1
            || colPos == grid[rowPos].length) {
            return;
        }

        if (grid[rowPos][colPos] == '0') {
            return;
        }
        grid[rowPos][colPos] = '0';

        for (int[] direction : MOVEMENTS) {
            convertIslandToSea(rowPos + direction[0], colPos + direction[1], grid);
        }
    }
}

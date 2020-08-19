package com.leet_code;

public class LC_463_Island_Perimeter {
    public static void main(String[] args) {
        int[][] island = { { 0, 1 } };
        int i = islandPerimeter(island);
        System.out.println(i);
    }

    public static int islandPerimeter(int[][] grid) {
        //row
        int[][] DIR = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

        int sides = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                final int i = grid[r][c];
                if (i == 1) {
                    for (int[] direction : DIR) {
                        int newRow = direction[0] + r;
                        int newCell = direction[1] + c;
                        //check perimeter
                        if (newCell == -1 || newCell == grid[r].length || newRow == -1 || newRow == grid.length) {
                            sides++;
                        } else if (grid[newRow][newCell] != 1) {
                            sides++;
                        }
                    }
                }
            }
        }
        return sides;
    }
}

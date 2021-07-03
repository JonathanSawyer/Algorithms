package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_5798 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(rotateGrid(
                new int[][] {
//                        { 4, 5, 8, 9, 4, 2, 4, 7, 2, 4 },
//                        { 7, 1, 9, 6, 6, 1, 4, 5, 7, 7 },
//                        { 7, 1, 5, 1, 1, 7, 10, 1, 3, 1 },
//                        { 7, 2, 2, 5, 2, 6, 6, 4, 7, 7 },
//                        { 1, 2, 3, 8, 4, 7, 6, 9, 6, 2 },
//                        { 5, 10, 3, 4, 7, 2, 7, 5, 3, 10 }, 4

{10,1,4,8},{6,6,3,10},{7,4,7,10},{1,10,6,1},{2,1,1,10},{3,8,9,2},{7,1,10,10},{7,1,4,9},{2,2,4,2},{10,7,5,10}},
        1)));
    }

    public static int[][] rotateGrid(int[][] grid, int k) {
        int h = grid.length;
        int w = grid[0].length;
        int[][] res = new int[h][w];

        int iterate = 0;
        final int until = Math.min(h, w) / 2;
        while (iterate < until) {
            final List<Integer> layer = new ArrayList<>();
            int f = iterate;

            // l -> r
            for (int cell = f; cell < (w - f); cell++) {
                layer.add(grid[f][cell]);
            }
            // t -> b
            for (int row = iterate + 1; row < h - f; row++) {
                layer.add(grid[row][w - f - 1]);
            }
            // r -> l
            for (int cell = w - f - 2; cell > f; cell--) {
                layer.add(grid[h - f - 1][cell]);
            }
            //b -> t
            for (int row = h - f - 1; row > f; row--) {
                layer.add(grid[row][f]);
            }

            int[] l = layer.stream().mapToInt(i -> i).toArray();

            rotate(l, k % l.length);
            transformLayer(f, w, h, l, res);
            iterate++;
        }
        return res;
    }

    public static void transformLayer(int f, int w, int h, int[] layer, int[][] res) {
        int i = 0;
        for (int cell = f; cell < (w - f); cell++) {
            res[f][cell] = layer[i];
            i++;
        }
        for (int row = f + 1; row < h - f; row++) {
            res[row][w - f - 1] = layer[i];
            i++;
        }
        for (int cell = w - f - 2; cell > f; cell--) {
            res[h - f - 1][cell] = layer[i];
            i++;
        }
        for (int row = h - f - 1; row > f; row--) {
            res[row][f] = layer[i];
            i++;
        }
    }

    public static void rotate(int[] nums, int k) {
        for(int i = 0; i < k; i++){
            int j, first;
            first = nums[0];

            for(j = 0; j < nums.length-1; j++){
                nums[j] = nums[j+1];
            }
            nums[j] = first;
        }
    }
}

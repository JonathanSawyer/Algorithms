package com.neat_coder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LC_1341_The_K_Weakest_Rows_in_a_Matrix {
    public static void run() {
        int[][] mats = {
                { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1 }
        };
        int[] ints = kWeakestRows(mats, 3);
    }

    public static class Tuple {
        public Tuple(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }
        public int index;
        public int sum;
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        if (mat.length == 0) {
            return new int[] {};
        }

        List<Tuple> tuples = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int y = 0; y < mat[i].length; y++) {
                final int val = mat[i][y];
                if (val == 0) {
                    break;
                }
                sum += val;
            }
            tuples.add(new Tuple(i, sum));
        }

        tuples.sort(Comparator.comparingInt(o -> o.sum));
        return tuples.stream().limit(k).mapToInt(i->i.index).toArray();
    }
}

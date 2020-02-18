package com.neet_coder;

public class LC_5340_Count_Negative_Numbers_in_a_Sorted_Matrix {
    public static void run() {

    }

    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int[] i : grid) {
            for(int z : i) {
                if(z < 0) {
                    count++;
                }
            }
        }
        return count;
    }
}

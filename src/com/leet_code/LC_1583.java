package com.leet_code;

public class LC_1583 {
    public static void main(String[] args) {
        System.out.println(unhappyFriends(4,
                new int[][]{
                        {1, 2, 3},
                        {3, 2, 0},
                        {3, 1, 0},
                        {1, 2, 0}},
                new int[][]{{0, 1}, {2, 3}}));
    }

    public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        // Each time we check we want to make sure that there isnt paired with soeone else.
//        for (int[] pair: pairs) {
//
//        }
//        for (int[] pair: pairs) {
//            int a = pair[0];
//            int b = pair[1];
//            final int[] preferenceForA = preferences[a];
//            final int[] preferenceForB = preferences[b];
//
//            preferenceForA
//        }
        return -1;
    }
}

package com.leet_code;

public class LC_886_Possible_Bipartition {
    public static void run() {
        int[][] dislikes = { { 1, 2 }, { 1, 3 }, { 2, 4 } };
        int N = 4;
        //group1 [1,4], group2 [2,3]
        boolean b = possibleBipartition(N, dislikes);

    }

    public static boolean possibleBipartition(int N, int[][] dislikes) {

        return true;
    }
}

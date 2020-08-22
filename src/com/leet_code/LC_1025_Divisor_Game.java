package com.leet_code;

import java.util.Arrays;

public class LC_1025_Divisor_Game {
    public static void main(String[] args) {
        //even always wins
        System.out.println(divisorGame(14));
    }

    public static boolean divisorGame(int N) {
        //You always play to get the other person to be on even.
        boolean[] moves = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    if (!moves[i - j]) {
                        moves[i] = true;
                        break;
                    }
                }
            }

        }
        System.out.println(Arrays.toString(moves));
        return moves[N];
//        return 0 == (N % 2);
    }
}

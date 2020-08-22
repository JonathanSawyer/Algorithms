package com.leet_code;

public class LC_1025_Divisor_Game {
    public static void main(String[] args) {
        System.out.println(divisorGame(3));
    }

    public static boolean divisorGame(int N) {
        return 0 == (N % 2);
    }
}

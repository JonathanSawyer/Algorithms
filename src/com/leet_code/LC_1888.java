package com.leet_code;

public class LC_1888 {
    public static void main(String[] args) {
        System.out.println(minFlips("01001001101"));
        //2
    }

    public static int minFlips(String s) {
        final char[] chars = s.toCharArray();
        int n = chars.length;
        final char[] prefix1 = new char[chars.length * 2];
        for (int i1 = 0; i1 < n * 2; i1++) {
            final int i = i1 >= n ? (i1 - n) : i1;
            prefix1[i1] = chars[i];
        }
        final char[] prefixA = new char[n];
        final char[] prefixB = new char[n];
        for (int i = 0; i < chars.length; i++) {
            prefixA[i] = i % 2 > 0 ? '1' : '0';
            prefixB[i] = i % 2 > 0 ? '0' : '1';
        }
        int min = Math.min(f(chars, prefixA), f(chars, prefixB));

        for (int i = 0, y = n; y < n * 2; i++, y++) {
            char l = prefix1[i];
            char r = prefix1[y];
            if (l != r) {
                min -= 2;
                return min;
            }
        }
        return min;
    }

    public static int f(char[] chars, char[] chars2) {
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars2[i]) {
                count++;
            }
        }
        return count;
    }
}

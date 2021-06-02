package com.leet_code;

import java.util.*;
import java.util.regex.Pattern;

public class TestGenerateUUID {
    private static final Pattern COMPILE = Pattern.compile("-");

    public static void main(String[] args) {
        //https://en.wikipedia.org/wiki/Modular_arithmetic
        //At current rate of increase will work for the mext 800 years :feelsgoodman:
        final int[] pows = new int[32];
        final int mod = 1_000;
        int[] freq = new int[mod];
        pows[0] = 1;
        for (int i = 1; i < pows.length; i++) {
            pows[i] = (pows[i - 1] * 16) % mod;
        }
        // At 10 million * 1000 = 10 billion images to overflow

        final UUID uuid = UUID.randomUUID();
        final String s = COMPILE.matcher(uuid.toString()).replaceAll("");
        final char[] chars = s.toCharArray();
        int bucket = 0;
        for (int j = 0, charsLength = chars.length; j < charsLength; j++) {
            final char c = chars[j];
            final int digit;
            if('a' <= c && c <= 'z') {
                digit = c - 'a' + 10;
            } else {
                digit = c - '0';
            }
            bucket = (bucket + (digit * pows[j])) % mod;
        }
        System.out.println("New Bucket: " + bucket);
    }
}


package com.leet_code;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LC_266_Palindrome_Permutation {
    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("code"));
    }

    public static boolean canPermutePalindrome(String s) {
        final char[] chars = s.toCharArray();
        final Map<Character, Integer> palindrome = new HashMap<>();
        for (Character c : chars) {
            palindrome.merge(c, 1, Integer::sum);
        }
        int i = s.length() % 2;
        //odd
        if (i > 0) {
            //Only one must be odd
            int odd = 0;
            for (Entry<Character, Integer> entry : palindrome.entrySet()) {
                final Integer integer = entry.getValue();
                odd += integer % 2 > 0 ? 1 : 0;
                if (odd > 1) {
                    return false;
                }
            }
        } else {
            //All must be even
            for (Entry<Character, Integer> entry : palindrome.entrySet()) {
                final Integer integer = entry.getValue();
                if (integer % 2 > 0) {return false;}
            }
        }
        return true;
    }
}

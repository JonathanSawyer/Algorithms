package com.neet_coder;

public class LC_5_Longest_Palindromic_Substring {
//    Given a string s, find the longest palindromic substring in s.
//    You may assume that the maximum length of s is 1000.
//
//    Example 1:
//
//    Input: "babad"
//    Output: "bab"
//    Note: "aba" is also a valid answer.
//            Example 2:
//
//    Input: "cbbd"
//    Output: "bb"
//
//    Hints:
//    How can we reuse a previously computed palindrome to compute a larger palindrome?
//    If “aba” is a palindrome, is “xabax” and palindrome? Similarly is “xabay” a palindrome?
//    Complexity based hint:
//    If we use brute-force and check whether for every start and end position a substring is a palindrome
//    we have O(n^2) start - end pairs and O(n) palindromic checks. Can we reduce the time for palindromic
//    checks to O(1) by reusing some previous computation.

    public static void run() {
        String babad = longestPalindrome("cbbd"); // bab
    }

    public static String longestPalindrome(String s) {
        String answer = "";
        for (int outer = 0; outer < s.length(); outer++) {
            final int sizeOfPalindrome1 = Math.abs(s.length() - 1 - outer);
            if (answer.length() > sizeOfPalindrome1) { break; }
            for (int inner = s.length() - 1; inner >= 0; inner--) {
                final int sizeOfPalindrome2 = Math.abs(inner - outer);
                if (answer.length() > sizeOfPalindrome2) { break; }
                if (isPalindrome(s, outer, inner)) {
                    answer = s.substring(outer, inner + 1);
                }
            }
        }
        return answer;
    }

    public static boolean isPalindrome(String value, int start, int end) {
        final char[] chars = value.toCharArray();
        while (start < end) {
            if (chars[start] == chars[end]) {
                end--;
                start++;
                continue;
            }
            return false;
        }
        return true;
    }
}

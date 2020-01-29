package com.neat_coder;

public class LC_5319_Remove_Palindromic_Subsequences {
    public static void run() {
        removePalindromeSub("baabb");
    }

    public static int removePalindromeSub(String s) {
        return 1;
    }

//    public static String longestPalindrome(String s) {
//        String answer = "";
//        for (int outer = 0; outer < s.length(); outer++) {
//            final int sizeOfPalindrome1 = Math.abs(s.length() - 1 - outer);
//            if (answer.length() > sizeOfPalindrome1) { break; }
//            for (int inner = s.length() - 1; inner >= 0; inner--) {
//                final int sizeOfPalindrome2 = Math.abs(inner - outer);
//                if (answer.length() > sizeOfPalindrome2) { break; }
//                if (isPalindrome(s, outer, inner)) {
//                    answer = s.substring(outer, inner + 1);
//                }
//            }
//        }
//        return answer;
//    }
//
//    public static boolean isPalindrome(String value, int start, int end) {
//        final char[] chars = value.toCharArray();
//        while (start < end) {
//            if (chars[start] == chars[end]) {
//                end--;
//                start++;
//                continue;
//            }
//            return false;
//        }
//        return true;
//    }
}

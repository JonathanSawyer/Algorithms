package com.leet_code;

public class LC_680_Valid_Palindrome_II {
    public static void main(String[] args) {
        System.out.println(validPalindrome(
                "ebcbbececabbacecbbcbe"));
    }

    public static boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();

        int i = 0, j = chars.length - 1;
        int differences = 0;
        while (i < j) {
            if (chars[i] != chars[j]) {
                differences++;
                if (chars[i] == chars[j - 1]) {
                    j--;
                } else if (chars[j] == chars[i + 1]) {
                    i++;
                } else {
                    System.out.println(i);
                    return false;
                }
            }

            i++;
            j--;
        }
        System.out.println(differences);
        return differences == 1 || differences == 0;
    }
}

// abbdca
//

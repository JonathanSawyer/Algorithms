package com.neet_coder;

public class LC_9_Palindrome_Number {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int temp = x;
        final StringBuilder builder = new StringBuilder();
        do {
            builder.append(temp % 10);
            temp /= 10;
        } while (temp > 0);
        return builder.toString().equals(String.valueOf(x));
    }

    public static void run() {
        boolean palindrome1 = isPalindrome(12345);
        boolean palindrome2 = isPalindrome(12345);
        System.out.println("12345" + palindrome1);
        System.out.println("1234554321" + palindrome2);
    }
}

package com.leet_code;

public class LC_344_Reverse_String {
    public static void run() {
        reverseString(new char[] { 'h', 'e', 'l', 'l', 'o' });
    }

    public static void reverseString(char[] s) {
        helper(0, s.length - 1, s);
        System.out.println(s);
    }

    public static void helper(int start,  int end, char[] s) {
        if (start >= end) {
            return;
        }
        char temp = s[end];
        s[end] = s[start];
        s[start] = temp;
        start++;
        end--;
        helper(start, end, s);
    }
}

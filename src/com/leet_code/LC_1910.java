package com.leet_code;

public class LC_1910 {
    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
    }

    public static String removeOccurrences(String s, String part) {
        while (true) {
            int i1 = s.indexOf(part);
            if (i1 == -1) {
                return s;
            }
            s = s.replace(part, "");
        }
    }
}

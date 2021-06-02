package com.leet_code.biweekly_51;

public class P_1844 {
    public static void main(String[] args) {
        System.out.println(replaceDigits("a1c1e1"));
        // abcdef
    }

    public static String replaceDigits(String s) {
        final char[] chars = s.toCharArray();
        final StringBuilder res = new StringBuilder();
        char prev = 'a';
        for (char aChar : chars) {
            if (Character.isDigit(aChar)) {
                res.append(Character.toString(prev + aChar - 48));
            } else {
                res.append(aChar);
            }
            prev = aChar;
        }
        return res.toString();
    }
}

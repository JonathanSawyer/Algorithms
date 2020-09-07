package com.leet_code;

public class LC_5507 {
    public static void main(String[] args) {
        char x = 'a';
        x += 1;
        System.out.println(x);

        System.out.println(modifyString("??yw?ipkj?"));
    }

    public static String modifyString(String s) {
        StringBuilder res = new StringBuilder();
        char[] charArray = s.toCharArray();
        char prev = 'A';
        for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
            final char cur = charArray[i];
            final char next = i == charArray.length - 1 ? 'A' : charArray[i + 1];
            if (cur == '?') {
                prev = toUniqueChar('a', prev, next == '?' ? 'a' : next);
            } else {
                prev = cur;
            }
            res.append(prev);
        }
        return res.toString();
    }

    public static Character toUniqueChar(char cur, char prev, char next) {
        while (cur == prev || cur == next) {
            cur += 1;
        }
        return cur;
    }
}

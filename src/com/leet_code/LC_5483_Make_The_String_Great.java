package com.leet_code;

public class LC_5483_Make_The_String_Great {
    public static void main(String[] args) {
        String a = makeGood("leEeetcodeAab");
        System.out.println(a);
    }

    public static String makeGood(String s) {
        boolean changes = true;
        StringBuilder string = new StringBuilder(s);
        String res = "";
        boolean lastOperation = false;
        while (changes) {
            changes = false;
            char[] chars = string.toString().toCharArray();
            string = new StringBuilder();
            for (int i = 0; i < chars.length - 1; i++) {
                lastOperation = false;
                if (chars[i] == chars[i + 1]) {
                    string.append(chars[i]);
                    continue;
                }

                char c = Character.toUpperCase(chars[i]);
                char c1 = Character.toUpperCase(chars[i + 1]);

                if (c != c1) {
                    string.append(chars[i]);
                    continue;
                }

                if (chars[i] != chars[i + 1]) {
                    lastOperation = i + 2 == chars.length ? true : false;
                    changes = true;
                    i++;
                }
            }
            if (chars.length > 0) {
                if (!lastOperation) {
                    string.append(chars[chars.length - 1]);
                }
            }

            res = string.toString();
        }
        return res;
    }
}

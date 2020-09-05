package com.leet_code;

public class LC_443_String_Compression {
    public static void main(String[] args) {
        char[] chars = { 'a', 'a', 'a', 'b', 'b', 'a', 'a' };
        System.out.println(compress(chars)); // 'a','2','b','2','c','3'
        System.out.println(chars);
    }

    public static int compress(char[] chars) {
        int len = 0;
        for (int i = 0, j = 0; i < chars.length; i = j) {
            while (j < chars.length && chars[i] == chars[j]) {
                j++;
            }
            chars[len++] = chars[i];
            if ((j - i) > 1) {
                for (char c : String.valueOf(j - i).toCharArray()) {
                    chars[len++] = c;
                }
            }
        }
        return len;
    }
}

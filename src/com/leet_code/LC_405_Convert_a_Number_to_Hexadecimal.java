package com.leet_code;

public class LC_405_Convert_a_Number_to_Hexadecimal {
    public static void main(String[] args) {
        System.out.println(toHex(-1));
    }

    final static String hex = "0123456789abcdef";

    public static String toHex(int num) {
        final StringBuilder sb = new StringBuilder();
        sb.append(hex.charAt(num & 15));
        num = num >>> 4;
        while (num != 0) {
            sb.append(hex.charAt(num & 15));
            num = num >>> 4;
        }
        return sb.reverse().toString();
    }
}

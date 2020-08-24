package com.leet_code;

public class LC_246_Strobogrammatic_Number {
    public static void main(String[] args) {
        System.out.print(isStrobogrammatic("6129"));
    }

    public static boolean isStrobogrammatic(String num) {
        char[] chars = num.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(Character c : chars) {
            if(c.equals('1') || c.equals('8') || c.equals('0')) {
                sb.append(c);
            }else if(c.equals('6')) {
                sb.append('9');
            }else if(c.equals('9')) {
                sb.append('6');
            }else {
                return false;
            }
        }
        StringBuilder reverse = sb.reverse();
        return reverse.toString().equals(num);
    }
}

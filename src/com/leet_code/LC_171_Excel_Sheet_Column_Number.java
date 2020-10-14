package com.leet_code;

public class LC_171_Excel_Sheet_Column_Number {
    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY")); //"AZ"
    }

    public static StringBuilder res = new StringBuilder();
    public static String titleToNumber(String n) {
//        final StringBuilder res = new StringBuilder();
//        while(n > 0){
//            n -= 1;
//            res.append((char) ('A' + n % 26));
//            n /= 26;
//        }
        return res.reverse().toString();
    }
}

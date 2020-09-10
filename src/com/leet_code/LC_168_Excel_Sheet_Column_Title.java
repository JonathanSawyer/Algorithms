package com.leet_code;

public class LC_168_Excel_Sheet_Column_Title {
    public static void main(String[] args) {
        System.out.println(convertToTitle(52)); //"AZ"
    }

    public static StringBuilder res = new StringBuilder();
    public static String convertToTitle(int n) {
        final StringBuilder res = new StringBuilder();
        while(n > 0){
            n -= 1;
            res.append((char) ('A' + n % 26));
            n /= 26;
        }
        return res.reverse().toString();
    }
}

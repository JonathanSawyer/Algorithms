package com.leet_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC_5388_Reformat_The_String {
    public static void run() {

    }

    public String reformat(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        Stack<Character> digits = new Stack<>();
        Stack<Character> chars1 = new Stack<>();

        StringBuilder result = new StringBuilder();
        for (Character c : chars) {
            if (Character.isDigit(c)) {
                digits.add(c);
            } else {
                chars1.add(c);
            }
        }

        if(Math.abs(digits.size() - chars1.size()) > 1) {
            return "";
        }

        boolean digitsGo = digits.size() > chars1.size();

        for (int i = 0; i < chars.length; i++) {
            if(digitsGo) {
                result.append(digits.pop());
                digitsGo = false;

            }else {
                result.append(chars1.pop());
                digitsGo = true;
            }
        }
        return result.toString();
    }
}

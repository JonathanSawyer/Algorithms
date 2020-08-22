package com.leet_code;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_67_Add_Binary {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }

    public static String addBinary(String a, String b) {
        int length = Math.max(a.length(), b.length());
        boolean carry = false;
        Deque<String> s = new ArrayDeque<>();
        for (int i = length - 1; i >= 0; i--) {
            if (i >= a.length()) {
                if (b.charAt(i) == '1') {
                    if (carry) {
                        s.addLast("0");
                    } else {
                        s.addLast("1");
                    }
                } else {
                    if (carry) {
                        s.addLast("1");
                        carry = false;
                    }
                }
            } else if (i >= b.length()) {
                if (a.charAt(i) == 1) {
                    if (carry) {
                        s.addLast("0");
                    } else {
                        s.addLast("1");
                    }
                } else {
                    if (carry) {
                        s.addLast("1");
                        carry = false;
                    }
                }
            } else if (a.charAt(i) == b.charAt(i)) {
                if (a.charAt(i) == '1') {
                    if (carry) {
                        s.addLast("1");
                    } else {
                        s.addLast("0");
                        carry = true;
                    }
                } else {
                    if (carry) {
                        s.addLast("1");
                        carry = false;
                    }
                }
            } else {
                s.addLast("1");
            }
        }
        if (carry) {
            s.addLast("1");
        }
        return s.toString();
    }
}

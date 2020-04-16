package com.leet_code;

public class LC_678_Valid_Parenthesis_String {
    public static void run() {
        boolean b = checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*");
        System.out.println(b);
    }

    public static boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c : s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) { break; }
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }
}

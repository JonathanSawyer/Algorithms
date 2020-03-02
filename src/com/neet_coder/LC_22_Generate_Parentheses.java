package com.neet_coder;

import java.util.ArrayList;
import java.util.List;

public class LC_22_Generate_Parentheses {
    //1. Key to this problem is you can never have less close brackets than open brackets.

    public static void run() {
        List<String> strings = generateParenthesis(3);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max) {
            backtrack(ans, cur + '(', open + 1, close, max);
        }
        if (close < open) {
            backtrack(ans, cur + ')', open, close + 1, max);
        }
    }
}




















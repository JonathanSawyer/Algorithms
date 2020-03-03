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

        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans,
                                 StringBuilder combination,
                                 int openingBrackets,
                                 int closingBrackets,
                                 int n) {
        if (n == closingBrackets) {
            ans.add(combination.toString());
        }

        if (openingBrackets > closingBrackets) {
            combination.append(')');
            backtrack(ans, combination, openingBrackets, closingBrackets + 1, n);
            combination.deleteCharAt(combination.length() - 1);
        }

        if (openingBrackets < n) {
            combination.append('(');
            backtrack(ans, combination, openingBrackets + 1, closingBrackets, n);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}

//()()()




















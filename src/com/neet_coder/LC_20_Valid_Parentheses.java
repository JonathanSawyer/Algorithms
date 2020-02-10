package com.neet_coder;

import java.util.HashMap;
import java.util.Stack;

public class LC_20_Valid_Parentheses {
    public static void run() {
        final boolean valid = isValid("()[]{}");
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> openParenthese = new HashMap<>();
        openParenthese.put('(', ')');
        openParenthese.put('[', ']');
        openParenthese.put('{', '}');

        final Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (openParenthese.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                Character pop = stack.pop();
                Character character = openParenthese.get(pop);
                if(c != character) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

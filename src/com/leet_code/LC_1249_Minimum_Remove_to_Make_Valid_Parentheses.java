package com.leet_code;

import java.util.LinkedList;
import java.util.Queue;

public class LC_1249_Minimum_Remove_to_Make_Valid_Parentheses {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee((t(c)o)de"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
    }

    public static String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();

        Queue<Character> opens = new LinkedList<>();
        Queue<Character> closes = new LinkedList<>();
        for (char aChar : chars) {
            if (aChar == '(') {
                opens.add('(');
            } else if (aChar == ')') {
                if (!(opens.size() <= closes.size())) {
                    closes.add(')');
                }
            }
        }

        while(opens.size() > closes.size()) {
            opens.poll();
        }

        for (Character charItem : chars) {
            if (charItem != '(' && charItem != ')') {
                res.append(charItem);
            } else if (charItem == '(' && !opens.isEmpty() && !closes.isEmpty()) {
                res.append(opens.poll());
            } else if (charItem == ')' && closes.size() != opens.size() && !closes.isEmpty()) {
                res.append(closes.poll());
            }
        }
        return res.toString();
    }
}

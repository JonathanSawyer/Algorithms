package com.neet_coder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC_17_Letter_Combinations_of_a_Phone_Number {
    public static void run() {
        List<String> strings = letterCombinations("23");
    }

    static HashMap<String, String> numbers = new HashMap<>();

    static List<String> result = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        numbers = new HashMap<>();
        numbers.put("2", "abc");
        numbers.put("3", "def");
        numbers.put("4", "ghi");
        numbers.put("5", "jkl");
        numbers.put("6", "mno");
        numbers.put("7", "pqrs");
        numbers.put("8", "tuv");
        numbers.put("9", "wxyz");

        if (!digits.isEmpty())
            backtrack("", digits);
        return result;
    }

    public static void backtrack(String combination, String nextDigits) {
        if (nextDigits.isEmpty()) {
            result.add(combination);
        } else {
            String digit = nextDigits.substring(0, 1);
            String letters = numbers.get(digit);
            for (int index = 0; index < letters.length(); index++) {
                String letter = numbers.get(digit).substring(index, index + 1);
                backtrack(combination + letter, nextDigits.substring(1));
            }
        }
    }
}

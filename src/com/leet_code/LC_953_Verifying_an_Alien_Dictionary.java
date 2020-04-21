package com.leet_code;

import java.util.Arrays;
import java.util.HashMap;

public class LC_953_Verifying_an_Alien_Dictionary {
    //    Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//    Output: true
//    Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
    public static void run() {
        System.out.println(isAlienSorted(new String[] { "kuvp", "q" }, "ngxlkthsjuoqcpavbfdermiywz"));
    }
    public static boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, String> dictionary = new HashMap<>();
        char[] chars = order.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            dictionary.put(chars[i], String.format("%02d", i + 1));
        }
        HashMap<String, String> valueToWord = new HashMap<>();
        String[] sorted = new String[words.length];
        for (int i1 = 0; i1 < words.length; i1++) {
            String word = words[i1];
            char[] chars1 = word.toCharArray();
            String[] value = new String[40];
            Arrays.fill(value, "00");
            for (int i = 0; i < chars1.length; i++) {
                Character c = chars1[i];
                value[i] = String.valueOf(dictionary.get(c));
            }
            sorted[i1] = String.join("", value);
            valueToWord.put(sorted[i1], word);
        }

        Arrays.sort(sorted);

        for (int i = 0; i < words.length; i++) {
            if (words[i] != valueToWord.get(sorted[i])) {
                return false;
            }
        }
        return true;
    }

}

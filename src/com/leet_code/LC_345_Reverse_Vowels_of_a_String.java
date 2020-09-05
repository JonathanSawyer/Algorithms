package com.leet_code;

import java.util.HashSet;
import java.util.List;

public class LC_345_Reverse_Vowels_of_a_String {
    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        HashSet<Character> vowels = new HashSet();
        vowels.addAll(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();
        while(i < j) {
            final char l = chars[i];
            final char r = chars[j];
            if(vowels.contains(l) && vowels.contains(r)) {
                chars[i] = r;
                chars[j] = l;
                i++;
                j--;
            }else if(vowels.contains(l)) {
                j--;
            }else if(vowels.contains(r)) {
                i++;
            }else {
                i++;
                j--;
            }
        }
        for(char c : chars) res.append(c);
        return res.toString();
    }
}

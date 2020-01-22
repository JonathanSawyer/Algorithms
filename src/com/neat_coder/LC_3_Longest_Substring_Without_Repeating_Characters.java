package com.neat_coder;

import java.util.HashSet;
import java.util.Set;

public class LC_3_Longest_Substring_Without_Repeating_Characters {
    public static void run() {
        int abcabcbb = lengthOfLongestSubstring("pwwkew"); //3
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        if(s.length() == 1) {
            return s.length();
        }
        final Set<Character> characters = new HashSet<>();
        for (int index = 0; index < s.length() - 1; index++) {
            int pointer = index + 1;
            characters.add(s.charAt(index));
            while (pointer < s.length()
                   && !characters.contains(s.charAt(pointer))) {
                characters.add(s.charAt(pointer));
                pointer++;
            }
            max = max > characters.size() ? max : characters.size();
            characters.clear();
        }
        return max;
    }
}

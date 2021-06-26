package com.leet_code;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LC_5784 {
    public static void main(String[] args) {
        System.out.println(makeEqual(new String[] { "abc", "abc", "bc" }));
    }

    public static boolean makeEqual(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (String s : words) {
            char[] chars = s.toCharArray();
            for (Character c : chars) { map.merge(c, 1, Integer::sum); }
        }
        for (Entry<Character, Integer> entry : map.entrySet()) {
            Character character = entry.getKey();
            Integer integer = entry.getValue();
            if (integer % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}

package com.neet_coder;

import java.util.HashMap;

public class comp_1 {
    public static void run() {
        int i = minSteps("friend", "family");
    }

    public static int minSteps(String s, String t) {
        HashMap<Character, Integer> mem = new HashMap<>();
        for (Character key : t.toCharArray()) {
            mem.merge(key, 1, Integer::sum);
        }
        int changes = 0;
        for (Character key : s.toCharArray()) {
            if (mem.containsKey(key)) {
                Integer integer = mem.get(key);
                if (integer == 1) {
                    mem.remove(key);
                } else {
                    mem.put(key, integer - 1);
                }
            } else {
                changes++;
            }
        }
        return changes;
    }
}

package com.neat_coder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC_49_Group_Anagrams {
    public static void run() {
        List<List<String>> i = groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List> map = new HashMap<>();
        if (strs.length == 0) {
            return new ArrayList();
        }
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}

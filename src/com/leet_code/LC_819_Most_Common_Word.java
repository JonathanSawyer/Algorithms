package com.leet_code;

import java.util.Arrays;
import java.util.HashMap;

public class LC_819_Most_Common_Word {
    public static void run() {
        System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c",
                                          new String[] { "a" }));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        final HashMap<String, Integer> frequencyMap = new HashMap<>();
        final String paragraphWithoutPunctuation = paragraph.replaceAll("\\p{P}", " ");
        System.out.println(paragraphWithoutPunctuation);
        String[] s = paragraphWithoutPunctuation.split(" ");
        String result = "";
        Integer occurances = Integer.MIN_VALUE;
        Arrays.sort(banned);
        for (String word : s) {
            String w = word.toLowerCase();
            if(w.isEmpty()) continue;
            int i = Arrays.binarySearch(banned, w);
            if (i < 0) {
                frequencyMap.merge(w, 1, Integer::sum);
                Integer count = frequencyMap.get(w);
                if (count > occurances) {
                    occurances = count;
                    result = w;
                }
            }
        }
        return result;
    }
}

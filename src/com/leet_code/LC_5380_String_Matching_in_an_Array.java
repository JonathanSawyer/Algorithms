package com.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_5380_String_Matching_in_an_Array {
    public static void run() {
        System.out.println(stringMatching(new String[]{"blue","green","bu"}));
    }

    public static List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        for(String w : words) {
            if(Arrays.stream(words).filter(s -> s.contains(w)).count() > 1) {
                result.add(w);
            }
        }
        return result;
    }
}

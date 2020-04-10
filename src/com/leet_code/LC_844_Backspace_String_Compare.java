package com.leet_code;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LC_844_Backspace_String_Compare {
    public static void run() {
        boolean b = backspaceCompare("ab#c", "ad#c");
        System.out.println(b);
    }
    public static boolean backspaceCompare(String S, String T) {
        char[] chars = S.toCharArray();
        char[] chars1 = T.toCharArray();
        System.out.println(get(chars));
        System.out.println(get(chars1));

        return get(chars).equals(get(chars1));
    }

    private static String get(char[] chars) {
        List<Character> s = new ArrayList<>();
        for(Character c : chars) {
            if(c.equals('#')) {
                if(!s.isEmpty()) {
                    s.remove(s.size() - 1);
                }
            }else {
                s.add(c);
            }
        }
        return s.stream().map(String::valueOf).collect(Collectors.joining());
    }
}

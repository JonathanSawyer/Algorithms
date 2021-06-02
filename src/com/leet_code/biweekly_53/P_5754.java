package com.leet_code.biweekly_53;

import java.util.HashSet;
import java.util.Set;

public class P_5754 {
    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("aaabc"));
    }

    public static int countGoodSubstrings(String s) {
        final char[] chars = s.toCharArray();
        if(chars.length < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 2, charsLength = chars.length; i < charsLength; i++) {
            int startInx = i - 2;
            final Set<Character> set = new HashSet<>();
            while(startInx <= i) {
                char aChar = chars[startInx];
                if(set.contains(aChar)) {
                    break;
                }
                set.add(aChar);
                startInx++;
            }
            if(set.size() == 3) {
                res++;
            }
        }
        return res;
    }
}

package com.leet_code;

import java.util.Arrays;

public class LC_392_Is_Subsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int previousSearch = 0;
        while(true) {
            previousSearch = Arrays.binarySearch(chars2, previousSearch, chars2.length, chars1[0]);
            if(previousSearch < 0) {
                return false;
            }
            int newStart = previousSearch + 1;
            for(int j = 1; j < chars1.length; j++) {
                final Character target = chars1[j];
                int i = Arrays.binarySearch(chars2, newStart, chars2.length, target);
                if(i < 0) {
                    return false;
                }
                newStart = j;
            }
            return true;
        }
    }
}

package com.leet_code;

import static java.lang.System.out;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LC_Perform_String_Shifts {
    //    Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
//    Output: "efgabcd"
//    Explanation:
//            [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
//            [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
//            [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
//            [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
    public static void run() {
        out.println(stringShift("abc", new int[][] { { 0, 1 }, {1,2} }));
    }

    public static String stringShift(String s, int[][] shift) {
        int totalShift = 0;
        for(int i = 0; i < shift.length; i++) {
            int dir = shift[i][0];
            int amount = shift[i][1];
            if(dir == 0) {
                totalShift-=amount;
            }else {
                totalShift+= amount;
            }
        }
        String newFront;
        String newBack;

        if(totalShift < 0) {
            totalShift = Math.abs(totalShift) % s.length();
            newFront = s.substring(totalShift);
            newBack = s.substring(0, totalShift);
        }else if(totalShift > 0) {
            totalShift %= s.length();
            newFront = s.substring(s.length() - totalShift, totalShift);
            newBack = s.substring(0, s.length() - totalShift);
        }else {
            return s;
        }
        return newFront + newBack;
    }
}

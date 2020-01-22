package com.neat_coder;

import java.util.HashMap;
import java.util.Map;

public class LC_13_Roman_to_Integer {
    public static void run() {
        int iv = romanToInt("III");
        int mcmxciv = romanToInt("MCMXCIV");
    }

    //    I can be placed before V (5) and X (10) to make 4 and 9.
//    X can be placed before L (50) and C (100) to make 40 and 90.
//    C can be placed before D (500) and M (1000) to make 400 and 900.
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int amount = 0;
        char[] chars = s.toCharArray();
        for (int index = 0; index < chars.length; index++) {
            Character currChar = chars[index];
            Character nextChar = index + 1 != chars.length ? chars[index + 1] : null;
            Integer currVal = map.get(chars[index]);
            Integer nextVal = index + 1 < chars.length ? map.get(chars[index + 1]) : 0;

            if ((nextChar != null)
                && ((currChar == 'I' & (nextChar == 'V' || nextChar == 'X'))
                    || (currChar == 'X' & (nextChar == 'L' || nextChar == 'C'))
                    || (currChar == 'C' & (nextChar == 'D' || nextChar == 'M')))) {
                amount += nextVal - currVal;
                index++;
                continue;
            } else {
                amount += currVal;
            }
        }
        return amount;
    }
}

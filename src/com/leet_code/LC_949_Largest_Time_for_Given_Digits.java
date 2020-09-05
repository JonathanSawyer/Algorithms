package com.leet_code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC_949_Largest_Time_for_Given_Digits {
    public static void main(String[] args) {
        System.out.println(largestTimeFromDigits(new int[] { 1, 2, 3, 4 }));
        System.out.println(largestTimeFromDigits(new int[] { 1, 2, 5, 5 }));
    }

    public static String largestTimeFromDigits(int[] A) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        final Set<Integer> digit1 = new HashSet<>();
        digit1.add(0);
        digit1.add(1);
        digit1.add(2);
        final Set<Integer> digit2 = new HashSet<>();
        digit2.add(0);
        digit2.add(1);
        digit2.add(2);
        digit2.add(3);

        int countDigit1 = 0;
        int countDigit2 = 0;
        for (int i : A) {
            if (i >= 5 && freq.containsKey(i) && freq.get(i) == 1) {
                return "E";
            }
            freq.merge(i, 1, Integer::sum);
        }

        StringBuilder res = new StringBuilder();
        if(freq.containsKey(3)) {

            res.append(3);
        }else if(freq.containsKey(2)) {
            res.append(3);
        }else if(freq.containsKey(1)) {
            res.append(3);
        }else if(freq.containsKey(0)) {
            res.append(3);
        }

        return String.valueOf("");
    }
}

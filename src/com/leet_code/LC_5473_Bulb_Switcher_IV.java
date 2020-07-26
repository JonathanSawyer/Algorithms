package com.leet_code;

import java.util.ArrayList;
import java.util.List;

public class LC_5473_Bulb_Switcher_IV {
    public static void main(String[] args) {
        System.out.print(minFlips("10111"));
    }

    public static int minFlips(String target) {
        int count = 0;
        List<Integer> bulbs = new ArrayList<>();
        for (Character c : target.toCharArray()) {
            bulbs.add(Character.getNumericValue(c));
        }
        for (int i = 0; i < bulbs.size(); i++) {
            if (!(count % 2 == 0)) {
                if (bulbs.get(i) == 0) {
                    count++;
                }
            } else if (bulbs.get(i) == 1) { count++; }
        }
        return count;
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}

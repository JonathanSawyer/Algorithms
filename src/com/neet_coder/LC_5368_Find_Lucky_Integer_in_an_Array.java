package com.neet_coder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class LC_5368_Find_Lucky_Integer_in_an_Array {
    public static void run() {
        int lucky = findLucky(new int[] { 1, 2, 2, 3, 3, 3 });
    }

    public static int findLucky(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        final Map<Integer, Integer> freq = new HashMap<>();
        for (int value : arr) {
            freq.merge(value, 1, Integer::sum);
        }

        final List<Entry<Integer, Integer>> collect =
                freq.entrySet().stream().filter(
                        integerIntegerEntry -> integerIntegerEntry.getKey()
                                                                  .equals(integerIntegerEntry.getValue()))
                    .collect(Collectors.toList());

        if (collect.isEmpty()) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for(Entry<Integer, Integer> entry : collect) {
            if(entry.getKey() > max) {
                max = entry.getKey();
            }
        }
        return max;
    }
}

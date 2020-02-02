package com.neat_coder;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LC_1342_Reduce_Array_Size_to_The_Half {
    public static void run() {
        int[] a = {
                2, 28, 92, 30, 100, 52, 28, 48, 91, 27, 66, 19, 11, 53, 91, 95, 74, 51, 65, 65, 96, 81, 21, 55,
                98, 3, 2, 89, 99, 57, 78, 34, 50, 2, 57, 76, 23, 90, 89, 36, 53, 22, 73, 59, 95, 45
        };
        int i = minSetSize(a);
    }

    public static int minSetSize(int[] arr) {
        int res = 0, target = arr.length / 2;
        final Map<Integer, Integer> freq = new HashMap<>();
        for (int value : arr) {
            freq.merge(value, 1, Integer::sum);
        }
        final List<Integer> values = freq
                .values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        for (int num : values) {
            if (target <= 0) {
                return res;
            }
            target -= num;
            res++;
        }
        return res;
    }
}

package com.leet_code;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class LC_1213_Intersection_of_Three_Sorted_Arrays {
    public static void main(String[] args) {
        System.out.println(arraysIntersection(new int[]{2,3,4,5}, new int[]{1,2,5,7,9}, new int[]{1,3,4,5,8, 1}));
    }

    public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        HashMap<Integer, Integer> intersection = new HashMap<>();
        for (int i : arr1) {
            intersection.put(i, 1);
        }
        for (int i : arr2) {
            if (intersection.containsKey(i) && intersection.get(i) == 1) {
                intersection.merge(i, 1, Integer::sum);
            }
        }
        for (int i : arr3) {
            if (intersection.containsKey(i)) {
                intersection.merge(i, 1, Integer::sum);
            }
        }
        return intersection.entrySet().stream().filter(
                integerIntegerEntry -> integerIntegerEntry.getValue() >= 3).map(
                Entry::getKey).sorted().collect(Collectors.toList());
    }
}

package com.leet_code;

import java.util.Arrays;
import java.util.HashSet;

public class LC_349_Intersection_of_Two_Arrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) { set1.add(i); }
        for (int i : nums2) { set2.add(i); }
        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        return set1.stream()
                   .mapToInt(Integer::intValue)
                   .toArray();
    }
}

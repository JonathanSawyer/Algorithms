package com.leet_code;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LC_448 {
    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> a = new HashSet<>();
        for (int i = 1; i <= nums.length; i++) { a.add(i); }
        for (int num : nums) { a.remove(num); }
        return a.stream().collect(Collectors.toUnmodifiableList());
    }
}

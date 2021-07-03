package com.leet_code;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LC_1909 {
    public static void main(String[] args) {
        // System.out.println(canBeIncreasing(new int[] { 1, 2, 10, 5, 7 }));
        System.out.println(canBeIncreasing(new int[] { 1, 1, 1 }));
        // System.out.println(canBeIncreasing(new int[] { 2, 3, 1, 2 }));
    }

    public static boolean canBeIncreasing(int[] nums) {
        List<Integer> sorted = new ArrayList<>();
        for (int num : nums) {
            sorted.add(num);
        }
        sorted = sorted.stream().sorted().collect(Collectors.toUnmodifiableList());
        int y = 0;
        boolean removed = false;
        for (int i = 0; y < nums.length || i < nums.length; i++) {
            if (nums[i] != sorted.get(y)) {
                if (removed) {
                    return false;
                }
                removed = true;
            } else {
                y++;
            }
        }
        return true;
    }
}

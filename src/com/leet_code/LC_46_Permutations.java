package com.leet_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class LC_46_Permutations {
    public static void run() {
        List<List<Integer>> permute = permute(new int[] { 1, 2, 3 });
    }

    public static void backtrack(int n,
                                 ArrayList<Integer> nums,
                                 List<List<Integer>> result,
                                 int first) {
        if (first == n) { result.add(new ArrayList<Integer>(nums)); }
        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            backtrack(n, nums, result, first + 1);
            Collections.swap(nums, first, i);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList();
        ArrayList<Integer> numsAsList = new ArrayList<>();
        for (int num : nums) { numsAsList.add(num); }
        backtrack(nums.length, numsAsList, result, 0);
        return result;
    }

    private LC_46_Permutations() {}
}


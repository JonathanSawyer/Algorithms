package com.neet_coder;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LC_46_Permutations {
    public static void run() {
        List<String> permute = permute(new int[] { 1, 2, 3 });
    }

    public static List<String> permute(int[] nums) {
        List<Integer> options = Arrays.stream(nums).boxed().collect(toList());
        backtrack(options, "");
        return results;
    }

    public static List<String> results = new ArrayList();

    public static void backtrack(List<Integer> nums, String combination) {
        if (nums.isEmpty()) {
            results.add(combination);
        }
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> nextPermutationOptions = nums.stream().skip(i + 1).collect(Collectors.toList());
            Integer permutationValue = nums.get(i);
            backtrack(nextPermutationOptions, combination + permutationValue);
        }
    }
}

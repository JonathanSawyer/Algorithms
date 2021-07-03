package com.leet_code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LC_39 {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        final Set<List<Integer>> res = new HashSet<>();
        final List<Integer> current = new ArrayList<>();
        backtracking(res, candidates, current,0,  target);
        return new ArrayList<>(res);
    }

    public static void backtracking(Set<List<Integer>> res, int[] candidates, List<Integer> current, int sum,
                                    int target) {
        if (sum == target) {
            List<Integer> collect = current.stream().sorted().collect(Collectors.toUnmodifiableList());
            res.add(collect);
        }
        for (int i = candidates.length - 1; i >= 0; i--) {
            current.add(candidates[i]);
            int nxt = candidates[i] + sum;
            if(nxt <= target) {
                backtracking(res, candidates, current, nxt, target);
            }
            current.remove(current.size() - 1);
        }
    }
}

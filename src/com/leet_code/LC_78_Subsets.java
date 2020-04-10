package com.leet_code;

import java.util.ArrayList;
import java.util.List;

public class LC_78_Subsets {

    public static void run() {
        List<List<Integer>> subsets = subsets(new int[] { 1, 2, 3 });
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        backtrack(res, nums, new ArrayList(), 0);
        return res;
    }

    public static void backtrack(List<List<Integer>> res,
                                 int[] nums,
                                 List<Integer> subset,
                                 int start) {
        res.add(new ArrayList(subset));
        for (int k = start; k < nums.length; k++) {
            subset.add(nums[k]);
            backtrack(res, nums, subset, k + 1);
            subset.remove(subset.size() - 1);
        }
    }
}

//            000 - empty set
//            001 - [c]
//            010 - [b]
//            011 - [b,c]
//            100 - [a]
//            101 - [a,c]
//            110 - [2,3]
//            111 - [1,2,3]
//
//            1 = 4
//            2 = 4
//            3 = 4
//
//
//    public static List<List<Integer>> subsets(int[] nums) {
//        final List<List<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < Math.pow(2, nums.length); i++) {
//            final List<Integer> curr = new ArrayList<>();
//            int num = i, idx = 0;
//            while (num != 0) {
//                if ((num & 1) == 1) {
//                    curr.add(nums[idx]);
//                }
//                num >>= 1;
//                idx++;
//            }
//            res.add(curr);
//        }
//
//        return res;

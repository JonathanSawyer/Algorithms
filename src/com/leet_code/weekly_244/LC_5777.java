package com.leet_code.weekly_244;

import java.util.TreeMap;

public class LC_5777 {
    public static void main(String[] args) {
        System.out.println(reductionOperations(new int[] { 5, 1, 3 }));
    }

    public static int reductionOperations(int[] nums) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int curr = nums.length;
        for (int num : nums) {
            tm.merge(num, 1, Integer::sum);
        }
        int res = 0;
        curr -= tm.pollFirstEntry().getValue();
        while (!tm.isEmpty()) {
            res += curr;
            curr -= tm.pollFirstEntry().getValue();
        }
        return res;
    }
}

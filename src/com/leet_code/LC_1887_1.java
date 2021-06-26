package com.leet_code;

import java.util.TreeMap;

public class LC_1887_1 {
    public static void main(String[] args) {
        System.out.println(reductionOperations(new int[] { 5, 1, 3 }));
    }

    public static int reductionOperations(int[] nums) {
        final TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        map.pollFirstEntry();
        int res = 0;
        int num = 1;
        while (!map.isEmpty()) {
            res += map.pollFirstEntry().getValue() * num++;
        }
        return res;
    }
}

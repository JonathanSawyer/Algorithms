package com.leet_code;

import java.util.HashMap;

public class LC_560_Subarray_Sum_Equals_K {
    public static void run() {
        subarraySum(new int[] { 1, 1, 1 }, 2);
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        final HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) { count += map.get(sum - k); }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

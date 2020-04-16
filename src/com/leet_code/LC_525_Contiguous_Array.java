package com.leet_code;

import static java.lang.System.out;

import java.util.HashMap;
import java.util.Map;

public class LC_525_Contiguous_Array {
    public static void run() {
        out.println(findMaxLength(new int[] { 0, 1, 0 }));
    }

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 1 ? 1 : -1);
            max = Math.max(count, max);
        }
        return max;
    }

}

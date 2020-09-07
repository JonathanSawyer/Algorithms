package com.leet_code;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LC_414_Third_Maximum_Number {
    public static void main(String[] args) {
        System.out.println(
                thirdMax(new int[] { 3, 2, 1, -3, 3, 4, 3, 4, 5, 6, 7, 8, 9, 2, 2, 3, 4, 5, 6, 6, 7, 8, 10 }));
    }

    static int[] sum = new int[3];

    public static int thirdMax(int[] nums) {
        sum[0] = (int) -10e9;
        sum[1] = (int) -10e9;
        sum[2] = (int) -10e9;
        Set<Integer> set = new HashSet();
        for (int i : nums) { set.add(i); }

        if (set.size() < 3) {
            return Collections.max(set);
        }

        set.remove(Collections.max(set));
        set.remove(Collections.max(set));
        return Collections.max(set);
    }
}

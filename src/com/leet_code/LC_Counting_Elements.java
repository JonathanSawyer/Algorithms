package com.leet_code;

import java.util.HashSet;
import java.util.Set;

//Given an integer array arr, count element x such that x + 1 is also in arr.
//
//        If there're duplicates in arr, count them seperately.
//
//
//
//        Example 1:
//
//        Input: arr = [1,2,3]
//        Output: 2
//        Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
public class LC_Counting_Elements {
    public static void run() {
        int i = countElements(new int[] { 1, 2, 3 });
    }

    public static int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x);
        }
        int count = 0;
        for (int x : arr) {
            if (set.contains(x)) {
                count++;
            }
        }
        return count;
    }
}

package com.leet_code;

import java.util.Arrays;

public class LC_1011_Capacity_To_Ship_Packages_Within_D_Days {
    //    Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
//    Output: 15
    public static void main(String[] args) {
        System.out.println(shipWithinDays(
                new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 5));

    }

    public static int shipWithinDays(int[] weights, int D) {
        //ship capacity weights
        int lo = Arrays.stream(weights).max().getAsInt(), hi = (int) 1e9;
        while (lo < hi) {
            // Ship Capacity
            int mid = lo + hi >>> 1;
            if (f(weights, mid, D)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        // can return lo or hi
        return lo;
    }

    public static boolean f(int[] weights,
                            int shipCapacity,
                            int d) {
        // 1,2,3,4,5,6,7,8,9,10
        // ship capacity 5
        // 1,2 3, 4, 5, 6
        int sum = 0;
        int days = 1;
        for (int i = 0; i < weights.length; i++)  {
            sum += weights[i];
            if (sum > shipCapacity) {
                sum = weights[i];
                days++;
            }
        }
        return days <= d;
    }

//    Explanation:
//    A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
//            1st day: 1, 2, 3, 4, 5
//            2nd day: 6, 7
//            3rd day: 8
//            4th day: 9
//            5th day: 10
//
//    Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting
//    the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
}

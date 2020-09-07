package com.leet_code;

public class LC_852_Peak_Index_in_a_Mountain_Array {
    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[] { 0, 1, 0 }));
    }

    public static int peakIndexInMountainArray(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mi = lo + hi >>> 1;
            if (A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }
}

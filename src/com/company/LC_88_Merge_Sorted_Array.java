package com.company;

public class LC_88_Merge_Sorted_Array {
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = nums1.length - 1;
        int p2 = m - 1;
        int p3 = n - 1;

        while (p2 >= 0 && p3 >= 0) {
            if (nums1[p2] > nums2[p3]) {
                nums1[p1] = nums1[p2];
                p2--;
            } else {
                nums1[p1] = nums2[p3];
                p3--;
            }
            p1--;
        }

        while(p2 >= 0 && p1 >= 0) {
            nums1[p1--] = nums1[p2--];
        }

        while(p3 >= 0 && p1 >= 0) {
            nums1[p1--] = nums2[p3--];
        }

        return nums1;
    }

    public static void run() {
        final int[] ints = { 1, 2, 3, 0, 0, 0 };
        int[] merge = merge(ints, 3, new int[] { 1, 2, 5, 6 }, 4);

    }
}

package com.company;

public class LC_88_Merge_Sorted_Array {
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {return nums1;}
        int nums1Index = 0;
        int nums2Index = 0;

        while (nums1Index < nums1.length) {
            if (nums1[nums1Index] >= nums2[nums2Index] || nums1Index >= m) {
                int temp = nums1[nums1Index];
                nums1[nums1Index] = nums2[nums2Index];
                nums2[nums2Index] = temp;
            }

            if (nums1[nums1Index] > nums2[nums2Index] || nums1Index >= m) {
                nums2Index++;
            }

            nums1Index++;
        }
        return nums1;
    }

    public static void run() {
        final int[] ints = { 4, 5, 6, 0, 0, 0 };
        merge(ints, 3, new int[] { 1, 2, 3 }, 3);
    }
}
//[4,5,6,0,0,0]
//        3
//        [1,2,3]
//        3

package com.neet_coder;

public class LC_75_Sort_Colors {
    public static void run() {
        int[] nums1 = { 2, 0, 2, 1, 1, 0 };
        int[] nums2 = { 0, 0, 2, 1, 1, 2 };
        int[] nums3 = { 2, 0, 1 };
        sortColors(nums1);
        sortColors(nums2);
        sortColors(nums3);
    }

    public static void sortColors(int[] nums) {
        int low = 0;
        int equal = 0;
        int high = nums.length - 1;

        final int pivot = 1;

        while (equal < high) {
            if (nums[equal] == pivot) {
                equal++;
            } else if (nums[equal] < pivot) {
                final int temp = nums[equal];
                nums[equal] = nums[low];
                nums[low] = temp;
                low++;
                equal++;
            } else {
                final int temp = nums[equal];
                nums[equal] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}

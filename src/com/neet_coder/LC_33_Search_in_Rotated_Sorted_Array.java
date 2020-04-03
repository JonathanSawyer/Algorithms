package com.neet_coder;

public class LC_33_Search_in_Rotated_Sorted_Array {
    public static void run() {
        int search = search(new int[] { 3, 4, 5, 6, 1, 2 }, 2);
    }

    public static int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        if(nums[0] == target) {
            return 0;
        }
        final int peakElement = findPeakElement(nums);
        if(nums[peakElement] == target) {
            return peakElement;
        }
        int i = binarySearchChan(nums, 0, peakElement, target);
        if (i == -1) {
            i = binarySearchChan(nums, peakElement + 1, nums.length - 1, target);
        }
        return i;
    }

    public static int binarySearchChan(int[] nums, int start, int end, int target) {
        int low = start;
        int high = end;
        while (low <= high) {
            final int mid = (low + high) >>> 1;
            final long midVal = nums[mid];

            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

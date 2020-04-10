package com.leet_code;

public class LC_162_Find_Peak_Element {
    public static void run() {
        int peakElement = findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 });
    }

    public static int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int mid = (l + r) / 2;
            if(nums[mid] > nums[mid + 1]) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }

    private static int binarySearch(long[] a, int fromIndex, int toIndex,
                                    long key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            // Can't remember exactly the reason for this.
            int mid = (low + high) >>> 1;
            long midVal = a[mid];

            if (midVal < key) { low = mid + 1; } else if (midVal > key) { high = mid - 1; } else {
                return mid; // key found
            }
        }
        return -(low + 1);  // key not found.
    }
}

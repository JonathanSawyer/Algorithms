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
}

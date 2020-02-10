package com.neet_coder;

public class LC_26_Remove_Duplicates_from_Sorted_Array {
    public static void run() {
        removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 });
    }

    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] != nums[slow]) {
                slow++;
                nums[slow] = nums[index];
            }
        }
        return slow + 1;
    }
}

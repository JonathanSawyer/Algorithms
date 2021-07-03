package com.leet_code;

public class LC_287 {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
    }

    //Floyd's Detection
    public static int findDuplicate1(int[] nums) {
        int a = 0;
        int b = 0;
        do {
            a = nums[a];
            b = nums[nums[b]];
        } while (a != b);

        a = 0;

        while (a != b) {
            a = nums[a];
            b = nums[b];
        }
        return a;
    }

    //
    public static int findDuplicate(int[] nums) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + high >>> 1;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

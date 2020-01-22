package com.neat_coder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_15_3Sum {
    public static void run() {
        List<List<Integer>> lists = threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
//        Given array nums = [-1, 0, 1, 2, -1, -4],
//        A solution set is:
//         [
//          [-1, 0, 1],
//          [-1, -1, 2]
//         ]
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        final List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                final int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip duplicates
                    final int leftValue = nums[left];
                    while (left < nums.length && nums[left] == leftValue) {
                        left++;
                    }
                    // Skip duplicates
                    final int rightValue = nums[right];
                    while (right > left && nums[right] == rightValue) {
                        right--;
                    }
                } else if (sum < 0) { left++;
                } else { right--; }
            }
            // Skip Duplicates
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
        return result;
    }
}

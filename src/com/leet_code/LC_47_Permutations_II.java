package com.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_47_Permutations_II {

    public static void main(String[] args) {
        List<List<Integer>> lists = permuteUnique(new int[] { 1, 1, 2 });
        lists.forEach(System.out::println);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        int i = nums.length - 2;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(getIntegers(nums));
        boolean changes = true;
        while(changes) {
            while (i >= 0 && nums[i + 1] <= nums[i]) {
                i--;
            }
            if (i == -1) {
                break;
            }
                int j = nums.length - 1;
                while (j >= 0 && nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
                reverse(nums, i + 1);
                res.add(getIntegers(nums));
        }
        return res;
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static List<Integer> getIntegers(int[] nums) {
        List<Integer> level = new ArrayList<>();
        for(int x = 0; x < nums.length; x++) {
            level.add(nums[x]);
        }
        return level;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

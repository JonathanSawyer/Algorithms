package com.leet_code;

import java.util.Arrays;

public class LC_167_Two_Sum_II_Input_array_is_sorted {
    public static void main(String[] args) {
        System.out.print(Arrays.toString(twoSum(new int[] { 2,3,4 }, 6)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int index = -1;
            if (i < numbers.length - 1) {
                index = Arrays.binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);
            } else {
                if (target - numbers[i] == numbers[i]) {
                    return new int[] { i + 1, index };
                }
            }
            if (index > -1) {
                return new int[] { i + 1, index + 1 };
            }
        }
        return new int[] {};
    }
}

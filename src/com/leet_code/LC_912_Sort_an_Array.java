package com.leet_code;

import java.util.Arrays;

public class LC_912_Sort_an_Array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[] { 5, 2, 3, 1 })));
    }

    public static int[] sortArray(int[] input) {
        if (input.length <= 1) {
            return input;
        }
        final int pivot = input.length / 2;
        final int[] left = sortArray(Arrays.copyOfRange(input, 0, pivot));
        final int[] right = sortArray(Arrays.copyOfRange(input, pivot, input.length));
        return merge(left, right);
    }

    public static int[] merge(int[] leftSide, int[] rightSide) {
        final int[] result = new int[leftSide.length + rightSide.length];
        int left = 0, right = 0, index = 0;
        while (left < leftSide.length && right < rightSide.length) {
            if (leftSide[left] < rightSide[right]) {
                result[index++] = leftSide[left++];
            } else {
                result[index++] = rightSide[right++];
            }
        }

        while (left < leftSide.length) {
            result[index++] = leftSide[left++];
        }

        while (right < rightSide.length) {
            result[index++] = rightSide[right++];
        }

        return result;
    }
}

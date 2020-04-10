package com.leet_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LC_384_Suffle_an_Array {
    public static void run() {
        Solution s = new Solution(new int[] { 1, 2, 3 });
        int[] shuffle1 = s.shuffle();
        int[] shuffle2 = s.shuffle();
        int[] shuffle3 = s.shuffle();
        int[] shuffle4 = s.shuffle();
    }

    public static class Solution {
        private final int[] _nums;
        private Random random;

        public Solution(int[] nums) {
            _nums = nums;
            random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return _nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            final int[] result = new int[_nums.length];
            final List<Integer> ints = new ArrayList<>();
            for (int i : _nums) {
                ints.add(i);
            }

            for (int index = 0; index < _nums.length - 1; index++) {
                int i = random.nextInt(ints.size());
                result[index] = ints.get(i);
                ints.remove(i);
            }
            result[_nums.length - 1] = ints.get(0);
            return result;
        }
    }
}

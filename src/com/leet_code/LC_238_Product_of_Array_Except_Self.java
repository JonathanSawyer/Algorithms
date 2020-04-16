package com.leet_code;

import static java.lang.System.out;

import java.util.Arrays;

public class LC_238_Product_of_Array_Except_Self {
    //    Input:  [1,2,3,4]
    //    Output: [24,12,8,6]
    public static void run() {
        productExceptSelf(new int[] { 1, 2, 3, 4 });
    }

    // using prefix sums
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int[] L = new int[length];
        int[] R = new int[length];

        int[] answer = new int[length];
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }
        Arrays.stream(L).forEach(value -> out.print(value + ", "));
        out.println();
        Arrays.stream(R).forEach(value -> out.print(value + ", "));

        for(int i = 0; i < nums.length; i++) {
            answer[i] = L[i] * R[i];
        }
        return answer;
    }
}

package com.company;

// vim u - undo
// CTRL + R - redo
// A - to append text at the end.
public class LC_268_Missing_Number {
    public static void run() {
        int i = missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 });
        //i == 8;
    }

    public static int missingNumber(int[] nums) {
        int targetedNumber = 0;
        int currentNumber = 0;
        for (int index = 0; index < nums.length; index++) {
            targetedNumber += index;
            currentNumber += nums[index];
        }
        targetedNumber += nums.length;
        return targetedNumber - currentNumber;
    }
}

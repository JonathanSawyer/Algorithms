package com.neet_coder;

import java.util.Arrays;

public class LC_55_Jump_Game {
//    Given an array of non-negative integers, you are initially positioned at the first index of the array.
//    Each element in the array represents your maximum jump length at that position.
//    Determine if you are able to reach the last index.

    public static void run() {
        final boolean canJump = canJump(new int[] { 2, 5, 0, 0 });
        //[3,2,1,0,4]
    }

    //Timeout using backtracking
    public static boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    //Dynamic Programming Top-down
    public enum status {
        GOOD,
        BAD,
        UNKNOWN
    }

    public static boolean canJump(int[] nums) {
        //return canJumpFromPosition(0, nums);

//        memo = new status[nums.length];
//        Arrays.fill(memo, status.UNKNOWN);
//        memo[nums.length - 1] = status.GOOD;
//        return canJumpFromPositionDP_TopDown(0, nums);

        // greedy
        int lastPos = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    static status[] memo;
    public static boolean canJumpFromPositionDP_TopDown(int position, int[] nums) {
        if (memo[position] != status.UNKNOWN) {
            return memo[position] == status.GOOD;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for(int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if(canJumpFromPositionDP_TopDown(nextPosition, nums)) {
                memo[nextPosition] = status.GOOD;
                return true;
            }
        }
        memo[position] = status.BAD;
        return false;
    }


}

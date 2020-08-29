package com.leet_code;

public class LC_724_Find_Pivot_Index {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] {-1,-1,-1,-1,-1,-1, -1 })); //2
    }

    public static int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}

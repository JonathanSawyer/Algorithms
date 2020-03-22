package com.neet_coder;

import java.util.ArrayList;
import java.util.List;

public class LC_5364_Create_Target_Array_in_the_Given_Order {
    public static void run() {
        int[] targetArray = createTargetArray(new int[] { 1,2,3,4,0 },
                                              new int[] { 0,1,2,3,0});
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index1 = index[i];
            result.add(index1, nums[i]);
        }

        int[] result2 = new int[result.size()];
        for (int i1 = 0; i1 < result.size(); i1++) {
            Integer i = result.get(i1);
            result2[i1] = i;
        }
        return result2;
    }
}

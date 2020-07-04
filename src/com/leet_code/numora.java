package com.leet_code;

import java.util.ArrayList;
import java.util.List;

public class numora {
    // -> max distance between peak points
    // -> linear scan and look for a change in the slope
    // -> need to consider starting and ending positions
    public int solution(int[] blocks) {
        List<Integer> peaks = new ArrayList<>();
        List<Integer> distance = new ArrayList<>();
        peaks.add(0);
        for (int i1 = 1; i1 < blocks.length - 1; i1++) {
            int cur = blocks[i1];
            int left = blocks[i1 - 1];
            int right = blocks[i1 + 1];
            if (cur > left && right < cur) {
                peaks.add(cur);
            }
        }
        peaks.add(blocks.length);





        int res = 0;
        for (int i = 0; i < blocks.length; i++) {
            int j = i;
            int k = i;
            // goes left
            //
            while (j > 1 && blocks[j - 1] >= blocks[j]) {
                j--;
            }
            // goes right
            //
            while (k < blocks.length - 1 && blocks[k] <= blocks[k + 1]) {
                k++;
            }
            res = Math.max(res, k - j + 1);
        }
        return res;
    }
}

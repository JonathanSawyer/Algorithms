package com.leet_code;

import java.util.ArrayList;
import java.util.List;

public class LC_119_Pascals_Triangle_II {
//    Input: 3
//    Output: [1,3,3,1]
    public static void main(String[] args) {
        List<Integer> row = getRow(3);
    }

    public static List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0) {
            return List.of(1);
        }
        return helper(0, rowIndex, List.of(1));
    }

    public static List<Integer> helper(int current, int rowIndex, List<Integer> previous) {
        if(current == rowIndex) {
            return previous;
        }
        final List<Integer> next = new ArrayList<>();
        next.add(1);
        for(int i = 0; i < previous.size() - 1; i++) {
            next.add(previous.get(i) + previous.get(i + 1));
        }
        next.add(1);
        return helper(current + 1, rowIndex, next);
    }
}

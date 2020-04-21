package com.leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Question_1 {
    public static void run() {
        // 9974
//        { 36376, 85652, 21002, 4510 },
//        { 68246, 64237, 42962, 9974 },
//        { 32768, 97721, 47338, 5841 },
//        { 55103, 18179, 79062, 46542 }
        int[][] luckyNumber = {
                { 36, 85, 21, 4 },
                { 68, 64, 42, 9 },
                { 32, 97, 47, 5 },
                { 55, 18, 79, 46 }
        };
        List<Integer> integers = luckyNumbers(luckyNumber);
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        // max value in the row
        // only keep the column
        HashMap<Integer, Integer> luckyMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int[] ints = matrix[i];
            int min = Integer.MAX_VALUE;
            Integer col = 0;
            for (int y = 0; y < ints.length; y++) {
                int value = ints[y];
                if (value <= min) {
                    min = value;
                    col = y;
                }
            }
            if (luckyMap.containsKey(col) && min > luckyMap.get(col)) {
                luckyMap.put(col, min);
            } else if (!luckyMap.containsKey(col)) {
                luckyMap.put(col, min);
            }

        }

        for(Entry<Integer, Integer> entry: luckyMap.entrySet()) {
            int max = entry.getValue();
            boolean otherMax = false;
            for (int i = 0; i < matrix.length; i++) {
                int matrix1 = matrix[i][entry.getKey()];
                if(matrix1 == entry.getValue()) {
                    continue;
                }
                if(matrix1 > max) {
                    otherMax = true;
                    break;
                }
            }
            if(!otherMax) {
                result.add(entry.getValue());
            }
        }
        return result;
    }

    public static class LC_937_Reorder_Data_in_Log_Files {
    }
}

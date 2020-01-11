package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_118_Pascals_Triangle_Naive {
    public static void run() {
        final List<List<Integer>> generate = generate(6);
    }

    public static List<List<Integer>> generate(int numRows) {
        if(numRows == 0) {
            return Collections.emptyList();
        }

        final List<List<Integer>> results = new ArrayList<>();

        final List<Integer> level1 = new ArrayList<>();
        level1.add(1);
        results.add(level1);
        if(numRows == 1) {
            return results;
        }

        for(int index = 1; index < numRows; index++) {
            final List<Integer> level = new ArrayList<>();
            level.add(1);
            final List<Integer> prevLevel = results.get(index - 1);
            for(int pIndex = 0; pIndex < prevLevel.size() - 1; pIndex++) {
                final Integer num1 = prevLevel.get(pIndex);
                final Integer num2 = prevLevel.get(pIndex + 1);
                level.add(num1 + num2);
            }
            level.add(1);
            results.add(level);
        }
        return results;
    }
}

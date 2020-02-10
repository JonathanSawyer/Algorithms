package com.neet_coder;

import java.util.ArrayList;
import java.util.List;

public class LC_118_Pascals_Triangle_Recursive {
    public static void run() {
        final List<List<Integer>> generate = generate(6);
    }

    public static List<List<Integer>> generate(int numRows) {
        final List<List<Integer>> results = new ArrayList<>();
        final List<Integer> level = new ArrayList<>();
        level.add(1);
        results.add(level);
        helper(1, numRows, results);
        return results;
    }

    public static void helper(int start, int numRows, List<List<Integer>> results) {
        if (numRows == start) {
            return;
        }
        final List<Integer> level = new ArrayList<>();
        final List<Integer> prev = results.get(start - 1);
        level.add(1);
        helper(start + 1, numRows, results);

        // TODO: Finish This


        level.add(1);
        results.add(level);

    }
}

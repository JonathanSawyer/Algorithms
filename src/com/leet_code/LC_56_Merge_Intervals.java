package com.leet_code;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

// Input: {{1,3},{2,6},{8,10},{15,18}}
// Output: {{1,6],{8,10],{15,18]]
// Explanation: Since intervals {1,3] and {2,6] overlaps, merge them into {1,6].
public class LC_56_Merge_Intervals {
    public static void run() {
        int[][] merge = merge(new int[][] { { 1, 4 }, { 2, 3 } });
        System.out.print(Stream.of(merge).map(ints -> ints[0] + " " + ints[1]).collect(toList()));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][] {};
        }
        List<int[]> intervalsSorted = Stream.of(intervals).sorted(Comparator.comparingInt(o -> o[0]))
                                            .collect(toList());
        List<Integer[]> result = new ArrayList<>();
        int[] activeInterval = new int[2];
        activeInterval[0] = intervalsSorted.get(0)[0];
        activeInterval[1] = intervalsSorted.get(0)[1];

        for (int i = 1; i < intervalsSorted.size(); i++) {
            int[] interval = intervalsSorted.get(i);
            if (interval[0] <= activeInterval[1]) {
                activeInterval[1] = Math.max(interval[1], activeInterval[1]);
            } else {
                Integer[] newEntry = new Integer[2];
                newEntry[0] = activeInterval[0];
                newEntry[1] = activeInterval[1];
                result.add(newEntry);
                activeInterval[0] = interval[0];
                activeInterval[1] = interval[1];
            }
        }

        Integer[] newEntry = new Integer[2];
        newEntry[0] = activeInterval[0];
        newEntry[1] = activeInterval[1];
        result.add(newEntry);

        int[][] resultArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i][0] = result.get(i)[0];
            resultArray[i][1] = result.get(i)[1];
        }
        return resultArray;
    }
}

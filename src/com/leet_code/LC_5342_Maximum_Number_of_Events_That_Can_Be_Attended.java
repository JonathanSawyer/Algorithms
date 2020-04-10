package com.leet_code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class LC_5342_Maximum_Number_of_Events_That_Can_Be_Attended {
    public static void run() {
        int[][] i = { { 1, 1 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 1, 6 }, { 1, 7 } };

        int[][] y = { { 1, 2 }, { 2, 2 }, { 3, 3 }, { 3, 4 }, { 3, 4 } };
        //int i1 = maxEvents(i);
        //int i2 = maxEvents(y); //4

        int[][] x = {{1,2},{2,3},{3,4},{1,2}};

        int[][] h = {{1,2},{1,2},{3,3},{1,5},{1,5}};

        int i1 = maxEvents(h);
    }

    public static int maxEvents(int[][] events) {
        Set<Integer> attended = new HashSet<>();
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        int count = 0;
        for (int[] i : events) {
            final int start = i[0];
            final int end = i[1];
            if (!attended.contains(start)) {
                count++;
                attended.add(start);
            } else if (!attended.contains(end)) {
                count++;
                attended.add(end);
            }
        }
        return count;
    }
}

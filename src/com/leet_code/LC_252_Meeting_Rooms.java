package com.leet_code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LC_252_Meeting_Rooms {
    public static void main(String[] args) {
        System.out.println(canAttendMeetings(new int[][] { { 5, 8 }, { 6, 8 } }));
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 1) {
            return true;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < intervals.length; i++) {
            final int[] prev = intervals[i - 1];
            final int[] curr = intervals[i];
            if (prev[0] == curr[0]) {
                return false;
            }
            if (curr[0] < prev[1]) {
                return false;
            }
        }
        return true;
    }
}

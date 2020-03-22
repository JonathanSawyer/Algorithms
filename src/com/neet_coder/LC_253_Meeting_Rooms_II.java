package com.neet_coder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LC_253_Meeting_Rooms_II {
    public static void run() {
        // 2
        minMeetingRooms(new int[][] { { 9, 10 }, { 4, 17 }, { 4, 9 } });
        // Track the maximum number of open rooms and return
        // start = o4, o4, c9, o9, c10, c17

    }

    public static int minMeetingRooms(int[][] intervals) {
        final Comparator<String> comparator = (o1, o2) -> {
            final Integer left = Integer.valueOf(o1.substring(1));
            final Integer right = Integer.valueOf(o2.substring(1));
            final boolean o1IsOpen = o1.charAt(0) == 'c';
            final boolean o2IsOpen = o2.charAt(0) == 'c';

            if (left == right) {
                return Boolean.compare(o2IsOpen, o1IsOpen);
            }

            return Integer.compare(left, right);

        };

        final List<String> sortedByStart = Arrays.stream(intervals)
                                                 .map(ints -> {
                                                     String start = "o" + ints[0];
                                                     String end = "c" + ints[1];
                                                     return new String[] { start, end };
                                                 })
                                                 .flatMap(Arrays::stream)
                                                 .sorted(comparator)
                                                 .collect(Collectors.toList());
        int currentOpenRooms = 0;
        int maxRooms = 0;
        for(int i = 0; i < sortedByStart.size(); i++) {
            String s = sortedByStart.get(i);
            char roomState = s.charAt(0);
            if(roomState == 'o') {
                currentOpenRooms++;
            }else {
                maxRooms = Math.max(currentOpenRooms, maxRooms);
                currentOpenRooms--;
            }
        }
        return maxRooms;
    }
}

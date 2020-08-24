package com.leet_code;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LC_5495_Most_Visited_Sector_in_a_Circular_Track {
    public static void main(String[] args) {
        System.out.println(mostVisited(7, new int[] { 1, 3, 5, 7 }));
        System.out.println(mostVisited(2, new int[] { 2, 1, 2, 1, 2, 1, 2, 1, 2 }));
        System.out.println(mostVisited(4, new int[] { 1, 3, 1, 2 }));
        System.out.println(mostVisited(4, new int[] {}));
    }

    public static List<Integer> mostVisited(int n, int[] rounds) {
        Map<Integer, Integer> counter = new HashMap();
        for (int i = 0; i < rounds.length - 1; i++) {
            int left = rounds[i];
            left = i == 0 ? rounds[i] : left + 1;
            left = left > n ? 1 : left;
            int right = rounds[i + 1];

            while (true) {
                counter.merge(left, 1, Integer::sum);
                if (left == right) {
                    break;
                }
                if (left == n) {
                    left = 1;

                } else {
                    left++;
                    if (left > n) {
                        break;
                    }
                }
            }
        }
        LinkedHashMap<Integer, Integer> collect = counter.entrySet()
                                                         .stream()
                                                         .sorted(comparingByValue(Collections.reverseOrder()))
                                                         .collect(toMap(Entry::getKey,
                                                                        Entry::getValue, (e1, e2) -> e2,
                                                                        LinkedHashMap::new));
        List<Integer> res = new ArrayList<>();
        int currentMax = -1;
        for (Entry<Integer, Integer> entry : collect.entrySet()) {
            Integer integer = entry.getKey();
            Integer integer2 = entry.getValue();
            if (integer2 >= currentMax) {
                currentMax = integer2;
                res.add(integer);
            }
        }
        Collections.sort(res);
        return res;
    }
}

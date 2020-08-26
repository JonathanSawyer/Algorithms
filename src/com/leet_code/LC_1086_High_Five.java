package com.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LC_1086_High_Five {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(highFive(new int[][] {
                { 1, 91 }, { 1, 92 }, { 2, 93 }, { 2, 97 }, { 1, 60 }, { 2, 77 }, { 1, 65 }, { 1, 87 },
                { 1, 100 }, { 2, 100 }, { 2, 76 }
        })));
    }

    public static int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> grouped = new HashMap<>();
        for(int[] item : items) {
            if(grouped.containsKey(item[0]))
            {
                grouped.get(item[0]).add(item[1]);
            }else {
                List<Integer> list = new ArrayList();
                list.add(item[1]);
                grouped.put(item[0], list);
            }
        }

        int[][] res = new int[grouped.size()][];
        int index = 0;
        for(Map.Entry<Integer, List<Integer>> entry: grouped.entrySet()) {
            res[index] = new int[]{entry.getKey(), entry.getValue().stream().sorted(Comparator.reverseOrder()).limit(5).mapToInt(Integer::intValue).sum() / 5};
            index++;
        }
        Arrays.sort(res, (a, b) -> Integer.compare(a[0], b[0]));
        return res;
    }
}

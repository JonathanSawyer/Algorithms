package com.leet_code;

import java.util.ArrayList;
import java.util.List;

public class LC_5509 {
    public static void main(String[] args) {
        System.out.println(minCost("aaabbbabbbb", new int[] { 3,5,10,7,5,3,5,5,4,8,1 }));
        // 26;
    }

    public static int minCost(String s, int[] cost) {
        char[] str = s.toCharArray();
        int totalCost = 0;
        for (int i = 0; i < str.length - 1; i++) {
            if (str[i] == str[i + 1]) {
                int y = i + 1 + 1;
                List<Integer> range = new ArrayList<>();
                range.add(cost[i]);
                range.add(cost[i + 1]);
                while (y < str.length && str[i] == str[y]) {
                    range.add(cost[y]);
                    y++;
                }
                i = i + range.size() - 1;


                range.remove(maxIndex(range) + i);
                    totalCost += range.stream().mapToInt(x ->x).sum();
                }
            }
        return totalCost;
    }

    public static int maxIndex(List<Integer> subCost) {
        int maximum = Integer.MIN_VALUE;
        int indexMax = -1;
        for (int i = 0; i < subCost.size(); i++) {
            if (subCost.get(i) > maximum) {
                maximum = subCost.get(i);
                indexMax = i;
            }
        }
        return indexMax;
    }
}

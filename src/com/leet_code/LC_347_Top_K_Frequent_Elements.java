package com.leet_code;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class LC_347_Top_K_Frequent_Elements {
    public static void run() {
        // Input: nums = [1,1,1,2,2,3], k = 2
        // Output: [1,2]
        // final List<Integer> integers1 = topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2);
        // [4,1,-1,2,-1,2,3], 2
        final List<Integer> integers2 = topKFrequent(new int[] { 4, 1, -1, 2, -1, 2, 3 }, 2);
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        final HashMap<Integer, Integer> sums = new HashMap<>();
        for (int num : nums) {
            sums.merge(num, 1, Integer::sum);
        }

        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> sums.get(o2) - sums.get(o1));
        final Set<Entry<Integer, Integer>> entry = sums.entrySet();
        for (Entry<Integer, Integer> e : entry) {
            priorityQueue.add(e.getKey());
        }

        final List<Integer> results = new LinkedList<>();
        while (k-- > 0) {
            results.add(priorityQueue.poll());
        }
        return results;
    }
}

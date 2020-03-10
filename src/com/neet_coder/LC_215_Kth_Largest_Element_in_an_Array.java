package com.neet_coder;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class LC_215_Kth_Largest_Element_in_an_Array {
    public static void run() {
        int kthLargest1 = findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2);
        int kthLargest2 = findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4);
    }

    public static int findKthLargest(int[] nums, int k) {
        final HashMap<Integer, Integer> sums = new HashMap<>();
        for (int num : nums) {
            sums.merge(num, 1, Integer::sum);
        }

        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        final Set<Entry<Integer, Integer>> entry = sums.entrySet();
        for (Entry<Integer, Integer> e : entry) {
            priorityQueue.add(e.getKey());
        }

        while(k-- > 1) {
            Integer count = sums.get(priorityQueue.peek());
            count--;
            if(count == 0) {
                priorityQueue.poll();
            }else {
                sums.put(priorityQueue.peek(), count);
            }
        }
        return priorityQueue.poll();
    }
}

package com.leet_code;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://en.wikipedia.org/wiki/Median_of_medians
// sort = n log n
// heap = n log k
// quick select = n
public class LC_215_Kth_Largest_Element_in_an_Array {
    public static void run() {
        int kthLargest1 = findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2);
        int kthLargest2 = findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4);
    }

    public static int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n));

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }
}

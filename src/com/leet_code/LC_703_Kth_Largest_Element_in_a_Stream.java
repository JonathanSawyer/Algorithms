package com.leet_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LC_703_Kth_Largest_Element_in_a_Stream {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = { 4, 5, 8, 2 };
        KthLargest kthLargest = new KthLargest(3, nums);
        System.out.println(kthLargest.add(3)); // returns 4
        System.out.println(kthLargest.add(5)); // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9)); // returns 8
        System.out.println(kthLargest.add(4)); // returns 8
    }

    public static class KthLargest {
        PriorityQueue<Integer> queue;
        int _k;
        public KthLargest(int k, int[] nums) {
            queue = new PriorityQueue<>(Collections.reverseOrder());
            _k = k;
            for(int n : nums) {
                queue.add(Integer.valueOf(n));
            }
        }

        public int add(int val) {
            queue.add(val);
            int i = _k;
            List<Integer> res = new ArrayList<>();
            while(!queue.isEmpty() && i > 0) {
                res.add(queue.peek());
                i--;
            }
            int j = queue.peek();
            queue.addAll(res);
            return j;
        }
    }
}

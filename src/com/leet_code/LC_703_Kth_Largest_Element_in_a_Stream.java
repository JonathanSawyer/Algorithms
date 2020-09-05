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
        private int K;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        public KthLargest(int k, int[] nums) {
            this.K = k;
            for(int a: nums){
                add(a);
            }

        }

        public int add(int val) {
            pq.add(val);
            // We will return kth largest, so removing element once size crossed K
            if(pq.size() > this.K){
                pq.poll();
            }
            return pq.peek();
        }
    }
}

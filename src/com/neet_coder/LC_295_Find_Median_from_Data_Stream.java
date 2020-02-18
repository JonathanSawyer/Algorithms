package com.neet_coder;

import java.util.Collections;
import java.util.PriorityQueue;

public class LC_295_Find_Median_from_Data_Stream {

    public static void run() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        medianFinder.addNum(6);
        medianFinder.findMedian();
    }

    public static class MedianFinder {

        PriorityQueue<Integer> high = new PriorityQueue<>(Collections.reverseOrder());
        private static PriorityQueue<Integer> low = new PriorityQueue();

        /** initialize your data structure here. */
        public MedianFinder() {

        }

        public void addNum(int num) {
            high.add(num);
            low.add(num);
        }

        public double findMedian() {
            return 0.0;
        }
    }
}

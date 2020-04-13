package com.leet_code;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class LC_1046_Last_Stone_Weight {
    public static void run() {
        out.println(lastStoneWeight(new int[] { 1,1,1,1 }));
    }

    public static int lastStoneWeight(int[] stones) {
        if(stones.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for(int s : stones) maxQueue.add(s);
        while(maxQueue.size() > 1) {
            Integer s1 = maxQueue.poll();
            Integer s2 = maxQueue.poll();
            if(s1 != s2) {
                int dif = Math.abs(s1 - s2);
                if(dif != 0) maxQueue.add(dif);
            }
        }
        return maxQueue.isEmpty() ? 0 :  maxQueue.poll();
    }
}

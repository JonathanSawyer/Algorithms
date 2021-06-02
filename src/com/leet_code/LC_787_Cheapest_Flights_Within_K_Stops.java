package com.leet_code;

import java.util.*;

public class LC_787_Cheapest_Flights_Within_K_Stops {
    public static void main(String[] args) {
        System.out.println(findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        final HashMap<Integer, List<int[]>> destinations = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        HashSet<String> seen = new HashSet<>();

        for (int[] flight : flights) {
            final int _src = flight[0];
            final int dest = flight[1];
            final int cost = flight[2];
            destinations.putIfAbsent(_src, new ArrayList<>());
            destinations.get(_src).add(new int[]{dest, cost});
        }
        pq.offer(new int[]{src, 0, K});
        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            final int dest = curr[0];
            final int price = curr[1];
            final int k = curr[2];
            String s = Integer.toString(curr[0]) + dest;
            if (dst == dest) {
                return price;
            }
            if (seen.contains(s) || k == 0) {
                continue;
            }
            seen.add(s);
            if(!destinations.containsKey(curr[0])) {
                continue;
            }
            final List<int[]> ints = destinations.get(curr[0]);
            for (int[] i : ints) {
                final int destination = i[0];
                final int cost = i[1];
                pq.offer(new int[]{destination, curr[1] + cost, curr[2] - 1});
            }
        }
        return -1;
    }
}

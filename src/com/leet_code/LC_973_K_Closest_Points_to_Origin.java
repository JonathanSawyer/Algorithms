package com.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC_973_K_Closest_Points_to_Origin {
    public static void main(String[] args) {
        Arrays.stream(kClosest(new int[][] { { 1, 3 }, { -2, 2 } }, 1))
              .forEach(ints -> {
                  System.out.print(ints[0] + "," + ints[1]);
                  System.out.println();
              });

        Arrays.stream(kClosest(new int[][] {{3,3},{5,-1},{-2,4}}, 2))
              .forEach(ints -> {
                  System.out.print(ints[0] + "," + ints[1]);
                  System.out.println();
              });
    }

    public static class KL {
        public int distance;
        public int[] points;

        public int getDistance() {
            return distance;
        }
    }

    public static int[][] kClosest(int[][] points, int K) {

        List<KL> kls = new ArrayList<>();
        for (int[] point : points) {
            int i = (Math.abs(point[0]) * Math.abs(point[0])) + (Math.abs(point[1]) * Math.abs(point[1]));
            KL kl = new KL();
            kl.distance = i;
            kl.points = point;
            kls.add(kl);
        }
        kls.sort(Comparator.comparing(KL::getDistance));
        int[][] res = new int[K][];
        int limit = K;
        for (KL kl1 : kls) {
            if (limit-- == 0) { break; }
            res[limit] = kl1.points;
        }
        return res;
    }
}

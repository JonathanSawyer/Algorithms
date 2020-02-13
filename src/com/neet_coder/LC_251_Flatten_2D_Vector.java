package com.neet_coder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LC_251_Flatten_2D_Vector {

    public static void run() {
        Vector2D iterator = new Vector2D(new int[][] { { 1, 2 }, { 3 }, { 4 } });
//        Vector2D iterator = new Vector2D(new int[][]{{}, {}});
        int next = iterator.next();// return 1
        int next1 = iterator.next();// return 2
        int next2 = iterator.next();// return 3
        boolean b = iterator.hasNext();// return true
        boolean b1 = iterator.hasNext();// return true
        int next3 = iterator.next();// return 4
        boolean b2 = iterator.hasNext();// return false
    }

    public static class Vector2D {
        private List<Integer> data;
        private int counter;

        public Vector2D(int[][] v) {
            data = new ArrayList<>();
            for (int[] vec : v) {
                for (int i : vec) {
                    data.add(i);
                }
            }
        }

        public int next() {
            return data.get(counter++);
        }

        public boolean hasNext() {
            return  counter < data.size();
        }
    }
}

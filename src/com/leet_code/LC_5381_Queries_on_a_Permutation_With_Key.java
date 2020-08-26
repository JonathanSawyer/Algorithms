package com.leet_code;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

public class LC_5381_Queries_on_a_Permutation_With_Key {
    public static void run() {
        int[] ints = processQueries(new int[] { 7,5,5,8,3 }, 8);
        // [3,1,2,0]
        for (int i : ints) {
            out.print(i + ",");
        }
    }

    public static int[] processQueries(int[] queries, int m) {
        List<Integer> range = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            range.add(i);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int index = range.indexOf(query);
            result[i] = index;

            for (int y = index; y > 0; y--) {
                range.set(y, range.get(y - 1));
            }
            range.set(0, query);
        }
        return result;
    }
}

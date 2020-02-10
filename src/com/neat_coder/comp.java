package com.neat_coder;

import java.util.HashMap;

public class comp {
    public static void run() {
        boolean a1 = checkIfExist(new int[] { -2,0,10,-19,4,6,-8});
        boolean a2 = checkIfExist(new int[] { 0, 0 });
        boolean b3 = checkIfExist(new int[] { 7, 1, 14, 11 });
        boolean c4 = checkIfExist(new int[] { 3, 1, 7, 11 });
        boolean d5 = checkIfExist(new int[] {});
        boolean d6 = checkIfExist(new int[] {
                102, -592, 457, 802, 98, -132, 883, 356, -857, 461, -453, 522, 250, 476, 991, 540, -852, -485,
                -637, 999, -803, -691, -880, 881, -584, 750, -124, 745, -909, -892, 304, -814, 868, 665, 50,
                -40, 26, -242, -797, -360, -918, -741, 88, -933, -93, 360, -738, 833, -191, 563, 449, 840, 806,
                -87, -950, 508, 74, -448, -815, -488, 639, -334
        });
    }

    public static boolean checkIfExist(int[] arr) {
        HashMap<Integer, Integer> mem = new HashMap<>();
        for (int key : arr) {
            mem.merge(key, 1, Integer::sum);
        }

        for (int i : arr) {
            if (i % 2 != 0) {
                continue;
            }
            final int i1 = i / 2;
            if (i1 == 0) {
                final Integer orDefault = mem.getOrDefault(0, 0);
                if (orDefault > 1) {
                    return true;
                }

            } else if (mem.containsKey(i1)) {
                return true;
            }
        }
        return false;
    }
}

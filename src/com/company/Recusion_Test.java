package com.company;

public class Recusion_Test {
    public static void run() {
        int i = allCombinations(0, new int[] { 1, 2, 3, 4, 5, 6 });
    }

    static int allCombinations(int index, int[] combinations) {
        if (index == combinations.length) {
            return 0;
        }

        return combinations[index]
               + allCombinations(index + 1, combinations);
    }
}

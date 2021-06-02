package com.leet_code;

import java.util.Arrays;

public class LC_1860 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(memLeak(6, 9)));
        System.out.println(Arrays.toString(memLeak(2, 2)));
        System.out.println(Arrays.toString(memLeak(8, 11)));
        System.out.println(Arrays.toString(memLeak(4, 6))); //[4,1,3]
        System.out.println(Arrays.toString(memLeak(10534, 0)));
    }

    public static int[] memLeak(int memory1, int memory2) {
        int crashTime = 0;
        while ((memory1 > 0 || memory2 > 0) && (crashTime < memory1 || crashTime < memory2)) {
            crashTime++;
            if (memory1 > memory2 || memory1 == memory2) {
                if (memory1 >= crashTime) {
                    memory1 -= crashTime;
                }
                // System.out.println(Arrays.toString(new int[] { crashTime, memory1, memory2 }));
            } else {
                if (memory2 >= crashTime) {
                    memory2 -= crashTime;
                }
                // System.out.println(Arrays.toString(new int[] { crashTime, memory1, memory2 }));
            }
        }
        return new int[] { ++crashTime, Math.max(memory1, 0), Math.max(memory2, 0) };
    }
}

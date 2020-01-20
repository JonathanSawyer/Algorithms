package com.company;

public class LC_1318_Minimum_Flips_to_Make_a_OR_b_Equal_to_c {
    public static void run() {
        //a = 2, b = 6, c = 5
        int i = minFlips(2, 6, 5);
        int v = minFlips(4, 2, 7);
        int z = minFlips(1, 2, 3);
    }

    public static int minFlips(int a, int b, int c) {
        int count = 0;
        int mask = 1;
        for (int index = 1; index < 32; index++) {
            final boolean aSet = (mask & a) != 0;
            final boolean bSet = (mask & b) != 0;
            final boolean cSet = (mask & c) != 0;

            if (cSet) {
               if(!aSet && !bSet) {
                   count++;
               }
            } else {
                if(aSet) {count++;}
                if(bSet) {count++;}
            }
            mask <<= 1;
        }

        return count;
    }
}

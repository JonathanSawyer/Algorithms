package com.company;

public class LC_191_Number_of_1_Bits {
    public static void run() {
        // Logical &
        int logicalAnd1 = 1 & 11; // 1
        int logicalAnd2 = 2 & 11; // 2
        int logicalAnd3 = 4 & 11; // 0
        int logicalAnd4 = 8 & 11; // 8
        int logicalAnd5 = 16 & 11; // 0
        int logicalAnd6 = 32 & 11; // 0

        System.out.println(logicalAnd1);
        System.out.println(logicalAnd2);
        System.out.println(logicalAnd3);
        System.out.println(logicalAnd4);
        System.out.println(logicalAnd5);
        System.out.println(logicalAnd6);

        System.out.println(hammingWeight(11));
    }

    public static int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((mask & n) != 0) {
                bits++;
            }
            mask <<= 1;
            // The bit will be shifted from position 1 to position 32.
            // 0000 0000 0000 0000 0000 0000 0000 0001
            // 0000 0000 0000 0000 0000 0000 0000 0010
            // 0000 0000 0000 0000 0000 0000 0000 0100
            // 0000 0000 0000 0000 0000 0000 0000 1000
            // 0000 0000 0000 0000 0000 0000 0001 0000
        }
        return bits;
    }
}
//-1     1
//-2     1
//-4     0
//-8     1
//-16    0

package com.neat_coder;

public class LC_461_Hamming_Distance {
    // Where bits are different
//    1   (0 0 0 1)
//    12  (1 1 0 0)
//           ↑   ↑
    public static void run() {
        int i = hammingDistance(1, 12);
    }

    public static int hammingDistance(int x, int y) {
        int different = 0;
        int mask = 1;
        for(int index = 1; index < 32; index++) {
            boolean aSet = (mask & x) != 0;
            boolean bSet = (mask & y) != 0;
            if ((!aSet && bSet) || (aSet && !bSet)) {
                different++;
            }
            mask <<= 1;
        }
        return different;
    }
}

//    public int hammingDistance(int x, int y) {
//        int xor = x ^ y;
//        int distance = 0;
//        while (xor != 0) {
//            if (xor % 2 == 1)
//                distance += 1;
//            xor = xor >> 1;
//        }
//        return distance;
//    }
// Brian Kernighan
//    O(log(n))
//    int count_set_bits(int n){
//        int count = 0; // count accumulates the total bits set
//        while(n != 0){
//            n &= (n-1); // clear the least significant bit set
//            count++;
//        }
//    }

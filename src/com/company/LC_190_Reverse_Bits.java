package com.company;

public class LC_190_Reverse_Bits {
    public static void run() {
        final String binary = "00000010100101000001111010011100";
        int i2 = Integer.parseInt(binary, 2);

        int i = reverseBits(i2);
        int ans = 1 << 0;

        int i1 = Integer.highestOneBit(ans);
    }

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int start = 0;
        int end = 31;

        while (start < end) {
            final int rangeStart = 1 << start;
            final int rangeEnd = 1 << end;
            start++;
            end--;

            final boolean startSet = (n & rangeStart) != 0;
            final boolean endSet = (n & rangeEnd) != 0;

            if (startSet && endSet) {continue;}
            if (!startSet && !endSet) {continue;}

            if(startSet) {
                n &= ~rangeStart;
                n |= rangeEnd;
            }else {
                n |= rangeStart;
                n &= ~rangeEnd;
            }
        }
        return n;
    }
}

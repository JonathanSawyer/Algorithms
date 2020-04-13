package com.leet_code;

import static java.lang.System.*;

public class LC_5383_Number_of_Ways_to_Paint_N_x_3_Grid {
    public static void run() {
        out.println(numOfWays(2));
    }

    public static int numOfWays(int n) {
        return (int) (Math.pow(24, n) - 9 * (Math.pow(8, n) + 18 * Math.pow(3, n) + 9 * Math.pow(2, n) - 24));
    }
}

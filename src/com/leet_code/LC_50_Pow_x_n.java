package com.leet_code;

public class LC_50_Pow_x_n {
    public static void main(String[] args)
    {
        double v = myPow(2.00000, 1, 10, 0);
    }

    public static double myPow(double x, int currentIndex, int n, double total) {
        if(currentIndex == n) {
            return total;
        }


        total = total == 0 ? 1 * x : x * total;

        return myPow(x, currentIndex + 1, n, total);
    }
}

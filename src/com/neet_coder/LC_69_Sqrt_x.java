package com.neet_coder;

public class LC_69_Sqrt_x {
    public static void run() {
        int i = mySqrt(100);
    }
    // Newtons Method
    // One of the best and widely used methods to compute sqrt is Newton's Method.
    // Here we'll implement the version without the seed trimming to keep things simple.
    // However, seed trimming is a bit of math and lot of fun, so here is a link if you'd
    // like to dive in.
    public static int mySqrt(int x) {
        if (x < 2) { return x; }
        double x0 = x;
        double x1 = (x0 + x / x0) / 2.0;
        while (Math.abs(x0 - x1) >= 1) {
            x0 = x1;
            x1 = (x0 + x / x0) / 2.0;
        }
        return (int) x1;
    }
}

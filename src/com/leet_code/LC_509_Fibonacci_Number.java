package com.leet_code;

public class LC_509_Fibonacci_Number {
    public static void main(String[] args) {
        int fib = fib(10);
    }

    public static int fib(int N) {
        if (N <= 1) {
            return N;
        }
        return fib(N - 1) + fib(N - 2);
    }
}

package com.neat_coder;

public class LC_204_Count_Prime {
    public static void run() {
        System.out.println(countPrimes(3));
    }

    public static int countPrimes(int n) {
        int counter = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                counter++;
            }
        }
        return counter;
    }

    private static boolean isPrime(int n) {
        int limit = (int)Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

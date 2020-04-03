package com.neet_coder;

import java.util.ArrayList;

public class LC_5178_Four_Divisors {
    public static void run() {
        int i = sumFourDivisors(new int[] { 21, 21 });
    }

    static int N = (int) 1E6;
    static boolean[] four = new boolean[N + 1];

    static void fourDistinctFactors() {
        final boolean[] primeAll = new boolean[N + 1];
        for (int prime = 2; prime * prime <= N; prime++) {
            if (!primeAll[prime]) {
                for (int i = prime * 2; i <= N; i += prime) { primeAll[i] = true; }
            }
        }
        final ArrayList<Integer> prime = new ArrayList<>();

        for (int p = 2; p <= N; p++) { if (!primeAll[p]) { prime.add(p); } }
        for (int index = 0; index < prime.size(); ++index) {
            int p = prime.get(index);
            if ((long) p * p * p <= N) { four[p * p * p] = true; }
            for (int j = index + 1; j < prime.size(); ++j) {
                int q = prime.get(j);
                if ((long) p * q > N) { break; }
                four[p * q] = true;
            }
        }
    }

    public static int sumFourDivisors(int[] nums) {
        fourDistinctFactors();
        int maxSum = 0;
        for (int num : nums) {
            if (four[num]) {
                final int cur = num + 1;
                int divisors = 2;
                int temp = 0;
                for (int i = 2; i < num - 1; i++) {
                    final int mod = num % i;
                    if (mod == 0) {
                        divisors++;
                        int no = num / i;
                        temp = no + i + cur;
                    }
                    if (divisors == 3) {
                        break;
                    }
                }

                maxSum += temp;

            }
        }
        return maxSum;
    }
}

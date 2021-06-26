package com.leet_code;

public class LC_5768 {
    public static void main(String[] args) {
        System.out.println(chalkReplacer(new int[] { 3, 4, 1, 2 }, 25));
    }

    public static int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int c : chalk) {
            sum += c;
        }
        k %= sum;

        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        return -1;
    }
}

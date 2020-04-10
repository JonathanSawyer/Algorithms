package com.leet_code;

public class LC_5360_Count_Largest_Group {
    public static void run() {
        int i = countLargestGroup(13);
    }

    public static int countLargestGroup(int n) {
        return countLargestGroup2(0, 0, String.valueOf(n).length(), String.valueOf(n));
    }

    public static int countLargestGroup2(int position,
                                         int previous_sum,
                                         int length,
                                         String num) {
        if (position == length) { return 1; }

        int res = 0;

        // sum of digits
        int sum = 0;

        // Traverse all digits from
        // current position to rest
        // of the length of string
        for (int i = position; i < length; i++) {
            sum += (num.charAt(i) - '0');

            // If forward_sum is greater
            // than the previous sum,
            // then call the method again
            if (sum >= previous_sum)

            // Note : We pass current
            // sum as previous sum
            {
                res += countLargestGroup2(i + 1, sum, length, num);
            }
        }

        // Total number of subgroups
        // till current position
        return res;
    }
}

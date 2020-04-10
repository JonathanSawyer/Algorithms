package com.leet_code;

import java.util.ArrayList;
import java.util.List;

public class LC_412_Fizz_Buzz {
    public static void run() {
        final List<String> strings = fizzBuzz(15);
    }

    public static List<String> fizzBuzz(int n) {
        final List<String> result = new ArrayList<>();
        for (int index = 1; index <= n; index++) {
            final boolean m3 = index % 3 == 0;
            final boolean m5 = index % 5 == 0;

            final StringBuilder sb = new StringBuilder();
            if (m3) {sb.append("Fizz");}
            if (m5) {sb.append("Buzz");}

            if (sb.length() == 0) {
                sb.append(index);
            }
            result.add(sb.toString());
        }
        return result;
    }
}

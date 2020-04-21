package com.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_937_Reorder_Data_in_Log_Files {
    public static void run() {
        String[] strings = reorderLogFiles(new String[] {
                "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"
        });
        for(String s : strings) {
            System.out.println(s);
        }
        // Output: ["let1 art can",
        //          "let3 art zero",
        //          "let2 own kit dig",
        //          "dig1 8 1 5 1",
        //          "dig2 3 6"]
    }

    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] split1 = a.split(" ", 2);
            String[] split2 = b.split(" ", 2);

            String logTypeA = split1[1];
            String logTypeB = split2[1];
            boolean isDigA = Character.isDigit(logTypeA.charAt(0));
            boolean isDigB = Character.isDigit(logTypeB.charAt(0));

            if (isDigA && isDigB) {
                return Integer.compare(logTypeB.charAt(0), logTypeA.charAt(0));
                //return logTypeA.compareTo(logTypeB);
            }
            if (isDigB) {
                return -1;
            }
            if (isDigA) {
                return 1;
            }
            // we are neither dig A or B
            return split1[1].compareTo(split2[1]);
        });
        return logs;
    }
}

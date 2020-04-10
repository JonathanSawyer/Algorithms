package com.code_jam_2020.qualifying;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Nesting_Depth {
    public static void run() throws FileNotFoundException {
        File f = new File(
                "/Users/st20911/Projects/Algorithms/src/com/code_jam_2020/qualifying/Nesting_Depth.txt");
        Scanner in = new Scanner(f);
        int testcase = 0;
        in.nextLine();
        while (in.hasNextLine()) {
            testcase++;
            char[] input = in.nextLine().toCharArray();
            StringBuilder result = new StringBuilder();
            char prev = '0';
            for (int i = 0; i < input.length; i++) {
                char cur = input[i];
                char nxt = i < input.length - 1 ? input[i + 1] : '0';

                if (cur == '1' && prev == '0') {
                    result.append('(');
                }
                if (cur == '1') {
                    result.append('1');
                }
                if (cur == '1' && nxt == '0') {
                    result.append(')');
                }
                if (cur == '0') {
                    result.append('0');
                }
                prev = cur;
            }
            System.out.println("Case #" + testcase + ": " + result);
        }
    }
}

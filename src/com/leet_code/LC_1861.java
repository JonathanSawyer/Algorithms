package com.leet_code;

import java.util.Arrays;

public class LC_1861 {
    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(rotateTheBox(new char[][] {
                        { '#', '#', '#', '.', '#', '.' }
                })));

    }

    // Count spaces and stones and when you encounter an obstacle then
    //
    public static char[][] rotateTheBox(char[][] box) {
        final char obstacle = '*';
        final char stone = '#';
        final char empty = '.';
        final char[][] result = new char[box[0].length][box.length];
        for (int j = 0, boxLength = box.length; j < boxLength; j++) {
            final char[] row = box[j];
            int stones = 0;
            int empties = 0;
            int startPoint = 0;
            for (int i = 0, rowLength = row.length; i < rowLength; i++) {
                final char cur = row[i];
                if (cur == obstacle || i == row.length - 1) {
                    if (cur == stone) {
                        stones++;
                    } else if (cur == empty) {
                        empties++;
                    }
                    if (i == row.length - 1 && cur != obstacle) {
                        i++;
                    }
                    for (int ii = startPoint; ii < i; ii++) {
                        if (empties > 0) {
                            row[ii] = empty;
                            empties--;
                        } else {
                            row[ii] = stone;
                            stones--;
                        }
                    }
                    startPoint = i + 1;
                } else if (cur == stone) {
                    stones++;
                } else if (cur == empty) {
                    empties++;
                }
            }
            for (int i = 0, rowLength = row.length; i < rowLength; i++) {
                result[i][box.length - (1 + j)] = row[i];
            }
        }
        return result;
    }
}

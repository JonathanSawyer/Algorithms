package com.company;

import java.util.HashSet;
import java.util.Set;

//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
//
//        Example 1:
//
//        Input:
//        [
//        [1,1,1],
//        [0,0,1],
//        [1,1,1]
//        ]
//        Output:
//        [
//        [0,0,1],
//        [0,0,0],
//        [0,0,1]
//        ]
public class LC_73_Set_Matrix_Zeroes {
    public static void run() {
        int[][] ints = new int[1][2];
        ints[0][0] = 0;
        ints[0][1] = 1;
//        ints[0][2] = 1;
//
//        ints[1][0] = 1;
//        ints[1][1] = 0;
//        ints[1][2] = 1;
//
//        ints[2][0] = 1;
//        ints[2][1] = 1;
//        ints[2][2] = 1;

        setZeroes(ints);
    }
    public static void setZeroes(int[][] matrix) {
//input    [[1,1,1],
//          [1,0,1],
//          [1,1,1]]

//output   [[1,0,1],
//          [1,0,1],
//          [1,0,1]]

//expected [[1,0,1],
//          [0,0,0],
//          [1,0,1]]
        final Set<Integer> skipR = new HashSet<>();
        final Set<Integer> skipC = new HashSet<>();
        for(int row = 0; row < matrix.length; row++) {
            if(skipR.contains(row)) {
                continue;
            }
            for(int column = 0; column < matrix[row].length; column++) {
                if(matrix[row][column] == 0) {
                    if(!skipC.contains(column)) {
                        for(int inner = 0; inner < matrix.length; inner++) {
                            matrix[inner][column] = 0;
                        }
                        skipC.add(column);
                    }
                    if(!skipR.add(row)) {
                        for(int inner = 0; row < matrix[row].length; inner++) {
                            matrix[row][inner] = 0;
                        }
                        skipR.add(column);
                    }

                }
            }
        }
    }
}

package com.leet_code;

public class LC_5488_Minimum_Operations_to_Make_Array_Equal {
    public static void main(String[] args) {
//      System.out.println(minOperations(3));
        System.out.println(minOperations(6));
    }

    public static int minOperations(int n) {
        int res = 0;
        for (int i = 1; i < n; i += 2) {
            res += Math.abs( n - i);
            System.out.println("res: " + res + " index: " + i + " math abs: " + Math.abs( n - i));
        }
        return res;
    }
}

// Input: n = 3
// Output: 2
// Explanation: arr = [1, 3, 5]
// First operation choose x = 2 and y = 0, this leads arr to be [2, 3, 4]
// In the second operation choose x = 2 and y = 0 again, thus arr = [3, 3, 3].

// Even its
//1 3 5 7 9
//2 4 5 6 8
//3 5 5 5 7
//4 5 5 5 6
//5 5 5 5 5

//1 3 5 7 9 11
//2 4 5 7 9 11
//3 5 5 7 9 11
//4 6 5 7 9 11
//5 7 5 7 9 11
//5 7 6 7 9 11

// 7 - 1    = [6]
// 7 - 3    = [4]
// 7 - 5    = [2]
// 9 - 7    = [2]
// 11 - 7   = [3]





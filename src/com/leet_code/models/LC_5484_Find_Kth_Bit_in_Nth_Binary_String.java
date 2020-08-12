package com.leet_code.models;

public class LC_5484_Find_Kth_Bit_in_Nth_Binary_String {
     public static void main(String[] args) {
         System.out.println(findKthBit(1, 1));
     }

    public static char findKthBit(int n, int k) {
        String s = Integer.toBinaryString(k);
        String s1 = new StringBuilder(s).reverse().toString();
        return s1.charAt(n - 1);
    }
}

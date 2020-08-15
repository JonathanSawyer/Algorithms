package com.leet_code;

public class LC_91_Decode_Ways {
    //    Input: "226"
//    Output: 3
//    Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
    public static void main(String[] args) {
        System.out.println(numDecodings("555"));

    }

    public static int numDecodings(String s) {
        if (s.matches("0\\d*")) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int sum = 0;
        boolean noZeros = false;
        for (int i = 0, charsLength = chars.length - 1; i < charsLength; i++) {
            int char1 = Character.getNumericValue(chars[i]);
            int char2 = Character.getNumericValue(chars[i + 1]);
            int i1 = Integer.valueOf(char2) + (Integer.valueOf(char1) * 10);
            if(i1 > 10) {
                noZeros = true;
            }
            if (i1 != 0 && i1 <= 26) {
                sum++;
            }
        }
        if(noZeros) {
            sum++;
        }
        return sum;
    }
}

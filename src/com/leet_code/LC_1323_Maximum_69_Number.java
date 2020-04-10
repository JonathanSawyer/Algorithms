package com.leet_code;

public class LC_1323_Maximum_69_Number {
//    Input: num = 9996
//    Output: 9999
//    Explanation: Changing the last digit 6 to 9 results in the maximum number
    public static void run() {
        int i = maximum69Number(6);
    }

    public static int maximum69Number(int num) {
        final String str = String.valueOf(num);
        for (int index = 0; index < str.length(); index++) {
            if(str.charAt(index) == '6') {
                return Integer.parseInt(str.substring(0, index) + '9' + str.substring(index + 1));
            }
        }
        return num;
    }
}

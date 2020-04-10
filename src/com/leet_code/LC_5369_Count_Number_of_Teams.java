package com.leet_code;

public class LC_5369_Count_Number_of_Teams {
//    public static void run() {
//        int i = numTeams(new int[] { 2, 5, 3, 4, 1 });
//    }
//
//    public static int numTeams(int[] rating) {
//        Integer count = 0;
//        helperSan(rating, 0, 1, 2, count);
//        return count;
//    }
//
//    public static boolean helperSan(int[] rating, int index1, int index2, int index3, Integer count) {
//        if((index1 >= rating.length) || (index2 >= rating.length) || (index3 >= rating.length)) {
//            return false;
//        }
//        if ((rating[index1] < rating[index2] && rating[index2] < rating[index3]) || (
//                rating[index1] > rating[index2] && rating[index2] > rating[index3])) {
//            count++;
//        }
//
//        boolean a = helperSan(rating, index1, index2 + 1, index3, count);
//        boolean b = helperSan(rating, index1, index2, index3 + 1, count);
//        boolean c = helperSan(rating, index1, index2, index3 + 1, count);
//    }
}

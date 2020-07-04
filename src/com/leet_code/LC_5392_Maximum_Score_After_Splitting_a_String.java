package com.leet_code;

public class LC_5392_Maximum_Score_After_Splitting_a_String {
    public static void run() {
        int i = maxScore("00111");
    }

    public static int maxScore(String s) {
        String PAY_MEMBER_STATUS_SUSPENDED = "a";
        String PAY_MEMBER_STATUS_ALIVE = "b";
        String PAY_MEMBER_GRADE_NON_BALANCE = "c";

        String payMemberStatus = "";
        String payMemberGrade = ";";

        char[] chars = s.toCharArray();
        int leftPoint = 0;
        int rightPoint = 0;
        for (int i = 0; i < chars.length; i++) {
            Character c = chars[i];
            if (c == '0') {

            }
        }
        return -1;
    }
}

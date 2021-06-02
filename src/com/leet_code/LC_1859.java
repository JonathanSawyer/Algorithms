package com.leet_code;

public class LC_1859 {
    public static void main(String[] args) {
        System.out.println(sortSentence("is1"));
    }

    public static String sortSentence(String s) {
        String[] s1 = s.split(" ");
        String[] rsult = new String[s1.length];
        for (String s2 : s1) {
            int index = Character.getNumericValue(s2.charAt(s2.length() - 1)) - 1;
            rsult[index] = s2.substring(0, s2.length() - 1);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0, rsultLength = rsult.length; i < rsultLength; i++) {
            String s2 = rsult[i];
            if (rsult.length > 1 && i != 0) {
                builder.append(' ');
            }
            builder.append(s2);
        }
        return builder.toString();
    }
}

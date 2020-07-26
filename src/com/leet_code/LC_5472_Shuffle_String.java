package com.leet_code;

public class LC_5472_Shuffle_String {
    public static void main(String[] args) {
        String aaiougrt = restoreString("aaiougrt", new int[] { 4, 0, 2, 6, 7, 3, 1, 5 });
        System.out.println(aaiougrt);
    }

    public static String restoreString(String s, int[] indices) {
        char[] c = new char[indices.length];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int index = indices[i];
            c[index] = charArray[i];
        }
        return String.valueOf(c);
    }
}

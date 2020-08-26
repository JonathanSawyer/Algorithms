package com.leet_code;

public class LC_408_Valid_Word_Abbreviation {
    public static void main(String[] args) {
        System.out.print(validWordAbbreviation("hi", "2i"));
    }

    public static boolean validWordAbbreviation(String word, String abbr) {
        StringBuilder actual = new StringBuilder();
        int length = word.length();
        char[] charArray = abbr.toCharArray();
        int j = 0;
        while (j < charArray.length) {
            Character character = charArray[j];
            if (!Character.isDigit(character)) {
                actual.append(character);
                int i = Math.min(word.length(), actual.length()) - 1;
                if(actual.charAt(i) != word.charAt(i)) {
                    return false;
                }
                j++;
                continue;
            }
            if (Character.getNumericValue(character) == 0) {
                return false;
            }
            int startOfCharacter = j;
            while (true) {
                if (j < charArray.length && Character.isDigit(charArray[j])) {
                    j++;
                } else {
                    break;
                }
            }
            String substring = abbr.substring(startOfCharacter, j);
            int number = Integer.valueOf(substring);
            for (int i = 0; i < number; i++) {
                if (actual.length() > length) {
                    return false;
                }
                actual.append(0);
            }
        }
        return actual.length() == length;
    }
}

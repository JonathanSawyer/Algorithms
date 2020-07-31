package com.leet_code;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class LC_929_Unique_Email_Addresses {
    public static void main(String[] args) {
        String[] input = {
                "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        };
        int i = numUniqueEmails(input);
        System.out.print(i);
    }

    public static int numUniqueEmails(String[] emails) {
        Pattern splitPreCompiledPattern = Pattern.compile("@");
        Map<String, Integer> emailMap = new HashMap<>();
        for (String email : emails) {
            String[] split = splitPreCompiledPattern.split(email);
            StringBuilder result = new StringBuilder();
            boolean dontTake = false;
            for (Character c : split[0].toCharArray()) {
                if (c == '.') { continue; }
                if (c == '+') { break; }
                result.append(c);
            }
            emailMap.merge(result.toString() + '@' + split[1], 1, Integer::sum);
        }
        return emailMap.size();
    }
}

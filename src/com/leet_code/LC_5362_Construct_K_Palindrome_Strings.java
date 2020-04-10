package com.leet_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class LC_5362_Construct_K_Palindrome_Strings {
    private static final Pattern COMPILE = Pattern.compile("");

    public static void run() {
        boolean annabelle = canConstruct("annabelle", 2);
    }

    public static boolean canConstruct(String s, int k) {
        List<List<String>> permute = permute(COMPILE.split(s), k);

        //List<List<String>> strings = partition(s);
        return true;
    }

    public static void backtrack(int n,
                                 ArrayList<String> nums,
                                 List<List<String>> result,
                                 int first, int k) {
        if (first == n) {
            result.add(new ArrayList<>(nums));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            backtrack(n, nums, result, first + 1, k);
            Collections.swap(nums, first, i);
        }
    }

    public static List<List<String>> permute(String[] nums, int k) {
        List<List<String>> result = new LinkedList();
        ArrayList<String> numsAsList = new ArrayList<>();
        for (String num : nums) {
            numsAsList.add(num);
        }
        backtrack(nums.length, numsAsList, result, 0, k);
        return result;
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(s, 0, list, res);
        return res;
    }

    public static void dfs(String s, int pos, List<String> list, List<List<String>> res) {
        if (pos == s.length()) { res.add(new ArrayList<>(list)); } else {
            for (int i = pos; i < s.length(); i++) {
                if (isPal(s, pos, i)) {
                    list.add(s.substring(pos, i + 1));
                    dfs(s, i + 1, list, res);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static boolean isPal(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) { return false; }
        }
        return true;
    }
}

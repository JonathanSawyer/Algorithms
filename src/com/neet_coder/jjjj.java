package com.neet_coder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jjjj {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (String w : words) {
            int m = 0;
            for (char c : w.toCharArray()) {
                m |= 1 << (c - 'a');
            }
            counts.merge(m, 1, Integer::sum);
        }

        final List<Integer> res = new ArrayList<>();
        for (String p : puzzles) {
            res.add(check(p, counts));
        }
        return res;
    }

    private static int check(String p, Map<Integer, Integer> counts) {
        int res = 0;
        int pMask = 0;
        for (char c : p.toCharArray()) {
            pMask |= 1 << (c - 'a');
        }
        for (Integer m : counts.keySet()) {
            if ((m & (1 << (p.charAt(0) - 'a'))) == 0) {
                continue;
            }
            boolean matched = true;
            for (int i = m; i > 0; i -= i & -i) {
                if ((pMask & i & -i) == 0) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                res += counts.get(m);
            }
        }
        return res;
    }
}

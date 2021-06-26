package com.leet_code;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LC_1899 {
    public static void main(String[] args) {

//        "qobftgcueho"
//        "obue"
//                [5,3,0,6,4,9,10,7,2,8]
        System.out.println(maximumRemovals(
                "rqmvwezfxczzeqokjww",
                "rezxczzeqw",
                new int[] { 18, 1, 3, 7, 4, 16, 14, 2, 15, 0, 6, 12, 17, 11, 13, 5, 9 }));
    }

    public static int maximumRemovals(String s, String p, int[] removable) {
        char[] sc = s.toCharArray();
        char[] subsequence = p.toCharArray();

        Map<Character, Set<Integer>> hm = new LinkedHashMap<>();
        for (Character sub : subsequence) {
            hm.put(sub, new HashSet<>());
        }

        for (int i = 0, scLength = sc.length; i < scLength; i++) {
            Character c = sc[i];
            if (hm.containsKey(c)) {
                hm.get(c).add(i);
            }
        }

        int count = 0;
        for (int j = 0, removableLength = removable.length; j < removableLength; j++) {
            int i = removable[j];
            char posVal1 = sc[i];
            if (!hm.containsKey(posVal1)) {
                count++;
                continue;
            }
            if (j >= removableLength - 2) {
                Set<Integer> integers1 = hm.get(posVal1);
                if (integers1.size() > 1) {
                    count++;
                }
                return count;
            }
            int ii = removable[j + 1];
            char posVal2 = sc[ii];

            Set<Integer> integers1 = hm.get(posVal1);
            Set<Integer> integers2 = hm.get(posVal2);
            integers1.remove(i);
            if (integers1.isEmpty()) {
                return count;
            }
            Integer min = Collections.min(integers1);
            Integer max = Collections.min(integers2);
            if (max < min) {
                return count;
            } else {
                count++;
            }
        }
        return count;
    }
}

// a (0, 3x)
// b (1, 5)

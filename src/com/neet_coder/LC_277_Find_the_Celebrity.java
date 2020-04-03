package com.neet_coder;

import java.util.ArrayList;
import java.util.List;

public class LC_277_Find_the_Celebrity {
    public int findCelebrity(int n) {
        List<Integer> candidate = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean celeb = true;
            for (int y = 0; y < n; y++) {
                if (y == i) { continue; }
                boolean a = knows(i, y);
                if (a) {
                    celeb = false;
                    break;
                }
            }
            if (celeb) {
                candidate.add(i);
            }
        }
        if (candidate.isEmpty()) {
            return -1;
        }

        for (int c : candidate) {
            boolean res = true;
            for (int i = 0; i < n; i++) {
                if (!knows(i, c)) {
                    res = false;
                }
            }
            if (res) {
                return c;
            }
        }
        return -1;
    }

    private boolean knows(int i, int y) {
        return false;
    }
}

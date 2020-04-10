package com.leet_code;

public class LC_278_First_Bad_Version {

    public static boolean[] versions = { false, false, false, true, true, true};
    public static void run() {
        int i = firstBadVersion(5);
        //i == 8;
    }

    public static int firstBadVersion(int n) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            boolean x = isBadVersion(mid);
            boolean y = isBadVersion(mid + 1);
            if (!x && !y) {
                low = mid + 1;
            } else if (x && y) {
                high = mid - 1;
            } else if (!x && y) {
                return mid + 1;
            }
        }
        return n;
    }

    private static boolean isBadVersion(int i) {
        return true;
    }
}

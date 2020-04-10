package com.leet_code;

import static java.lang.System.out;

//1095. Find in Mountain Array
public class LC_1095_Find_in_Mountain_Array {
    public static void run() {
        out.println(findInMountainArray(3, new MountainArray()));
    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        final int mountaintLength = mountainArr.length();
        int l = 0, r = mountaintLength - 1;
        while (l < r) {
            final int m = (l + r) >>> 1;
            final int k1 = mountainArr.get(m);
            final int k2 = mountainArr.get(m + 1);
            final int mid = (l + r) / 2;
            if (k1 > k2) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        out.println(l);

        final int pe = l;
        l = 0;
        r = pe;
        int lowerBound = -1;
        while (l <= r) {
            final int m = (l + r) >>> 1;
            if (m == mountaintLength) {
                break;
            }
            final int k = mountainArr.get(m);
            if (k < target) {
                l = m + 1;
            } else if (k > target) {
                r = m - 1;
            } else {
                lowerBound = m;
                break;
            }
        }

        if (lowerBound != -1) {
            return lowerBound;
        }

        int upperBound = -1;
        l = pe;
        r = mountainArr.length();
        while (l <= r) {
            final int m = (l + r) >>> 1;
            if (m == mountaintLength) {
                break;
            }
            final int k = mountainArr.get(m);
            if (target < k) {
                l = m + 1;
            } else if (target > k) {
                r = m - 1;
            } else {
                upperBound = m;
                break;
            }
        }
        return upperBound;
    }

    public static class MountainArray {
        public int get(int index) {
            return new int[] { 1,2,3,4,5,3,1 }[index];
        }

        public int length() {
            return 7;
        }
    }
}

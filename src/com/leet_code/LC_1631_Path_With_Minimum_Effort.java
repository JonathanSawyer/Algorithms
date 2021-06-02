package com.leet_code;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_1631_Path_With_Minimum_Effort {
    public static void main(String[] args) {

    }

    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] seen = new boolean[n][m];
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            int x = curr[1];
            int y = curr[2];
            if (x == n - 1 && y == m - 1) {
                return curr[0];
            }
            if (seen[x][y]) {
                continue;
            }
            seen[x][y] = true;
            for (int[] dir : DIRS) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    pq.offer(
                            new int[]{Math.max(curr[0], Math.abs(heights[x][y] - heights[nx][ny])), nx, ny}); }
            }
        }
        return -1;
    }
}

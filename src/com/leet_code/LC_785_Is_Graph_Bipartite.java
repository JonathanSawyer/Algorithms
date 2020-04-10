package com.leet_code;

public class LC_785_Is_Graph_Bipartite {
    public static void run() {
//        0----1
//        |    |
//        |    |
//        3----2
        boolean bipartite = isBipartite(new int[][] { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } });
    }

    public static enum Color {
        BLUE,
        RED
    }

    public static boolean isBipartite(int[][] graph) {
        final Color[] colors = new Color[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == null && !dfs(graph, i, colors, Color.RED)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int[][] graph, int at, Color[] colors, Color color) {
        if (colors[at] != null) {
            return colors[at] == color;
        }
        colors[at] = color;
        for (int n : graph[at]) {
            if (!dfs(graph, n, colors, color == Color.RED ? Color.BLUE : Color.RED)) {
                return false;
            }
        }
        return true;
    }
}

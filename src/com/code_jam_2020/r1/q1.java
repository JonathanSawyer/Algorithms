package com.code_jam_2020.r1;

import static java.lang.System.out;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class q1 {
    static int rowCount;
    static int colCount;
    static int[][] arrA;

    public static void run() throws FileNotFoundException {
//        File f = new File(
//                "/Users/st20911/Projects/Algorithms/src/com/code_jam_2020/r1/q1.txt");
//        Scanner in = new Scanner(f);
//        in.nextLine();

        //start exploring then at each point as if we need to explore more.

        int n = 300;
//        while (in.hasNextLine()) {
            List<Integer> row =
                    new ArrayList<>() {
                        {
                            add(1);
                        }
                    };

            for (int k = 1; k <= n; k++) {
                row.add((int) ((row.get(row.size() - 1) * (long) (n - k + 1)) / k));
            }
        int maze[][] =
                {
                        { 1},
                        { 1, 1, 0, 1 },
                        { 0, 1, 0, 1 },
                        { 1, 1, 1, 1 }
                };

        // stores number of unique paths from source to destination
        int count = 0;

        // 2D matrix to keep track of cells involved in current path
        boolean[][] visited = new boolean[maze.length][maze.length];

        // start from source cell (0, 0)
        count = countPaths(maze, 0, 0, visited, count);

        out.println("Total number of unique paths are " + count);

    }

    // Check if cell (x, y) is valid or not
    private static boolean isValidCell(int x, int y, int C, int R)
    {
        if (x < 0 || y < 0 || x >= R || y >= C)
            return false;

        return true;
    }

    private static int countPaths(int maze[][], int x, int y, boolean visited[][], int count)
    {
        int C = maze[x].length;
        int R = maze.length;
        // if destination (bottom-rightmost cell) is found,
        // increment the path count
        if (x == C - 1 && y == R - 1)
        {
            count++;
            return count;
        }

        // mark current cell as visited
        visited[x][y] = true;

        // if current cell is a valid and open cell
        if (isValidCell(x, y, C, R) && maze[x][y] == 1)
        {
            // go down (x, y) --> (x + 1, y)
            if (x + 1 < R && !visited[x + 1][y])
                count = countPaths(maze, x + 1, y, visited, count);

            // go up (x, y) --> (x - 1, y)
            if (x - 1 >= 0 && !visited[x - 1][y])
                count = countPaths(maze, x - 1, y, visited, count);

            // go right (x, y) --> (x, y + 1)
            if (y + 1 < C && !visited[x][y + 1])
                count = countPaths(maze, x, y + 1, visited, count);

            // go left (x, y) --> (x, y - 1)
            if (y - 1 >= 0 && !visited[x][y - 1])
                count = countPaths(maze, x, y - 1, visited, count);
        }

        // backtrack from current cell and remove it from current path
        visited[x][y] = false;

        return count;
    }
}

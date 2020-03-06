package com.neet_coder;
// Given a 2D board and a word, find if the word exists in the grid.
//
// The word can be constructed from letters of sequentially adjacent cell, where
// "adjacent" cells are those horizontally or vertically neighboring.
// The same letter cell may not be used more than once.
//
//Example:
//
//board =
//        [
//        ['A','B','C','E'],
//        ['S','F','C','S'],
//        ['A','D','E','E']
//        ]
//
//        Given word = "ABCCED", return true.
//        Given word = "SEE", return true.
//        Given word = "ABCB", return false.

public class LC_79_Word_Search {
    public static void run() {
        char[][] chars = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        final boolean abcced = exist(chars, "ABCCED");
        final boolean see = exist(chars, "SEE");
        final boolean abcb = exist(chars, "ABCB");
    }

    public static boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (backtrack(board, r, c, chars, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int[][] directions = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

    public static boolean backtrack(char[][] board, int row, int col, char[] chars, int charIndex) {
        if (charIndex >= chars.length) {
            return true;
        }
        if (row < 0 || row == board.length || col == board[row].length || col < 0) {
            return false;
        }

        if (board[row][col] != chars[charIndex]) {
            return false;
        }
        board[row][col] = '0';
        for (int[] direction : directions) {
            final boolean result = backtrack(board,
                                             row + direction[0],
                                             col + direction[1],
                                             chars,
                                             charIndex + 1);
            if (result) {
                return true;
            }
        }
        board[row][col] = chars[charIndex];
        return false;
    }
}

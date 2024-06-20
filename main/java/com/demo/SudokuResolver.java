package com.demo;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SudokuResolver {

    private int[][] board;

    public String solveSudoku(final String input) {
        board = new int[9][9];
        String[] lines = input.split("\\n");

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (lines[i].substring(j, j + 1).matches("[1-9]")) {
                    board[i][j] = Integer.parseInt(lines[i].substring(j, j + 1));
                } else {
                    board[i][j] = 0;
                }
            }
        }

        if (solve()) {
            return Arrays.stream(board)
                    .map(row -> Arrays.stream(row)
                            .boxed()
                            .map(Object::toString)
                            .map(String.class::cast)
                            .collect(Collectors.joining()))
                    .collect(Collectors.joining("\n"));
        } else {
            return "No solution exists";
        }
    }

    private boolean solve() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (solve()) {
                                return true;
                            }

                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int[][] board, int row, int col, int num) {
        // Check row
        for (int x = 0; x < 9; x++) {
            if (board[row][x] == num) {
                return false;
            }
        }

        // Check column
        for (int x = 0; x < 9; x++) {
            if (board[x][col] == num) {
                return false;
            }
        }

        // Check 3x3 sub-grid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
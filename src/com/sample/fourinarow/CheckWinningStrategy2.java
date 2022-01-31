package com.sample.fourinarow;

/**
 * Evaluates if a given position has winning hand by searching all possible patterns that involves the position
 *
 */
public class CheckWinningStrategy2 {

    public static boolean checkIfWinning(Position position, String[][] board) {
        checkHorizontal(position, board);
        if (!position.isWinner()) checkVertical(position, board);
        if (!position.isWinner()) checkLeftCross(position, board);
        if (!position.isWinner()) checkRightCross(position, board);
        return position.isWinner();
    }

    /**
     * checks all possible horizontal patterns with current position in one of the four possible positions
     * @param position
     * @param board
     */
    private static void checkHorizontal(Position position, String[][] board) {
        int row = position.row;
        int column = position.column;
        String color = board[row][column];
        int maxColumnIdx = position.maxColumnIdx;
        if ((column + 3 <= maxColumnIdx) &&
                (board[row][column + 1].equals(color) && board[row][column + 2].equals(color) && board[row][column + 3].equals(color))) {
            position.setWinner(true);
        }
        if (!position.isWinner() && (column - 1 >= 0 && column + 2 <= maxColumnIdx) &&
                (board[row][column - 1].equals(color) && board[row][column + 1].equals(color) && board[row][column + 2].equals(color))) {
            position.setWinner(true);
        }
        if (!position.isWinner() && (column - 2 >= 0 && column + 1 <= maxColumnIdx) &&
                (board[row][column - 2].equals(color) && board[row][column - 1].equals(color) && board[row][column + 1].equals(color))) {
            position.setWinner(true);
        }
        if (!position.isWinner() && (column - 3 >= 0) &&
                (board[row][column - 3].equals(color) && board[row][column - 2].equals(color) && board[row][column - 1].equals(color))) {
            position.setWinner(true);
        }
    }

    /**
     * checks all possible vertical patterns with current position in one of the four possible positions
     *
     * @param position
     * @param board
     */
    private static void checkVertical(Position position, String[][] board) {
        int row = position.row;
        int column = position.column;
        String color = board[row][column];
        int maxRowIdx = position.maxRowIdx;
        if ((row + 3 <= maxRowIdx) &&
                (board[row + 1][column].equals(color) && board[row + 2][column].equals(color) && board[row + 3][column].equals(color))) {
            position.setWinner(true);
        }
        if (!position.isWinner() && (row - 1 >= 0 && row + 2 <= maxRowIdx) &&
                (board[row - 1][column].equals(color) && board[row + 1][column].equals(color) && board[row + 2][column].equals(color))) {
            position.setWinner(true);
        }
        if (!position.isWinner() && (row - 2 >= 0 && row + 1 <= maxRowIdx) &&
                (board[row - 2][column].equals(color) && board[row - 1][column].equals(color) && board[row + 1][column].equals(color))) {
            position.setWinner(true);
        }
        if (!position.isWinner() && (row - 3 >= 0) &&
                (board[row - 3][column].equals(color) && board[row - 2][column].equals(color) && board[row - 1][column].equals(color))) {
            position.setWinner(true);
        }
    }

    /**
     * checks all possible left cross patterns with current position in one of the four possible positions
     *
     * @param position
     * @param board
     */
    private static void checkLeftCross(Position position, String[][] board) {
        int row = position.row;
        int column = position.column;
        String color = board[row][column];
        int maxRowIdx = position.maxRowIdx;
        int maxColumnIdx = position.maxColumnIdx;
        if ((row + 3 <= maxRowIdx && column + 3 <= maxColumnIdx) &&
                (board[row + 1][column + 1].equals(color) && board[row + 2][column + 2].equals(color) && board[row + 3][column + 3].equals(color))) {
            position.setWinner(true);
        }
        if (!position.isWinner() && (row - 1 >= 0 && column - 1 >= 0 && row + 2 <= maxRowIdx && column + 2 <= maxColumnIdx) &&
                (board[row - 1][column - 1].equals(color) && board[row + 1][column + 1].equals(color) && board[row + 2][column + 2].equals(color))) {
            position.setWinner(true);
        }
        if (!position.isWinner() && (row - 2 >= 0 && column - 2 >= 0 && row + 1 <= maxRowIdx && column + 1 <= maxColumnIdx) &&
                (board[row - 2][column - 2].equals(color) && board[row - 1][column - 1].equals(color) && board[row + 1][column + 1].equals(color))) {
            position.setWinner(true);
        }
        if (!position.isWinner() && (row - 3 >= 0 && column - 3 >= 0) &&
                (board[row - 3][column - 3].equals(color) && board[row - 2][column - 2].equals(color) && board[row - 1][column - 1].equals(color))) {
            position.setWinner(true);
        }
    }

    /**
     * checks all possible right cross patterns with current position in one of the four possible positions
     *
     * @param position
     * @param board
     */
    private static void checkRightCross(Position position, String[][] board) {
        int row = position.row;
        int column = position.column;
        String color = board[row][column];
        int maxRowIdx = position.maxRowIdx;
        int maxColumnIdx = position.maxColumnIdx;
        if ((row + 3 <= maxRowIdx && column - 3 >= 0) &&
                (board[row + 1][column - 1].equals(color) && board[row + 2][column - 2].equals(color) && board[row + 3][column - 3].equals(color))) {
            position.setWinner(true);
        }
        if (!position.isWinner() && (row - 1 >= 0 && column + 1 <= maxColumnIdx && row + 2 <= maxRowIdx && column - 2 >= 0) &&
                (board[row - 1][column + 1].equals(color) && board[row + 1][column - 1].equals(color) && board[row + 2][column - 2].equals(color))) {
            position.setWinner(true);
        }
        if (!position.isWinner() && (row - 2 >= 0 && column + 2 <= maxColumnIdx && row + 1 <= maxRowIdx && column - 1 >= 0) &&
                (board[row - 2][column + 2].equals(color) && board[row - 1][column + 1].equals(color) && board[row + 1][column - 1].equals(color))) {
            position.setWinner(true);
        }
        if (!position.isWinner() && (row - 3 >= 0 && column + 3 <= maxColumnIdx) &&
                (board[row - 3][column + 3].equals(color) && board[row - 2][column + 2].equals(color) && board[row - 1][column + 1].equals(color))) {
            position.setWinner(true);
        }
    }
}

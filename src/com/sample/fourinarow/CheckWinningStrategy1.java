package com.sample.fourinarow;

import java.util.ArrayList;
import java.util.List;

import static com.sample.fourinarow.Position.DEFAULT_SLOT_VALUE;


/*
- This strategy keeps track of all the positions that have winning chance
- Evaluates all winnable positions on every play; deletes positions that have no chance of winning
- returns true if any of the position wins
 */
public class CheckWinningStrategy1 {

    public static boolean checkIfWinning(Player currentPlayer, String[][] board) {
        List<Position> positions = new ArrayList<>(currentPlayer.getWinnablePositions());
        for (Position pos : positions) {
            updatePosition(pos, board);
            if (!pos.isWinnable()) {
                currentPlayer.removePosition(pos);
            } else if (pos.isWinner()) {
                return true;
            }
        }
        return false;
    }

    public static void updatePosition(Position position, String[][] board) {
        if (position.isLeftPossible() && !position.isWinner()) {
            checkLeft(position, board);
        }
        if (position.isRightPossible() && !position.isWinner()) {
            checkRight(position, board);
        }
        if (position.isTopPossible() && !position.isWinner()) {
            checkTop(position, board);
        }
        if (position.isRightCrossPossible() && !position.isWinner()) {
            checkRightCross(position, board);
        }
        if (position.isLeftCrossPossible() && !position.isWinner()) {
            checkLeftCross(position, board);
        }
    }

    private static void checkLeftCross(Position position, String[][] board) {
        int row = position.row;
        int column = position.column;
        String color = board[row][column];
        int count = 0;
        for (int i = row - 1, j = column - 1; i >= row - 3 && j >= column - 3; i--, j--) {
            if (!board[i][j].equals(DEFAULT_SLOT_VALUE) && !board[i][j].equals(color)) {
                position.setLeftCrossPossible(false);
                break;
            }
            if (board[i][j].equals(color)) {
                count++;
            }
        }
        if (count == 3) {
            position.setWinner(true);
        }
    }

    private static void checkRightCross(Position position, String[][] board) {
        int row = position.row;
        int column = position.column;
        String color = board[row][column];
        int count = 0;
        for (int i = row - 1, j = column + 1; i >= row - 3 && j <= column + 3; i--, j++) {
            if (!board[i][j].equals(DEFAULT_SLOT_VALUE) && !board[i][j].equals(color)) {
                position.setRightCrossPossible(false);
                break;
            }
            if (board[i][j].equals(color)) {
                count++;
            }
        }
        if (count == 3) {
            position.setWinner(true);
        }
    }

    private static void checkTop(Position position, String[][] board) {
        int row = position.row;
        int column = position.column;
        String color = board[row][column];
        int count = 0;
        for (int i = row - 1; i >= row - 3; i--) {
            if (!board[i][column].equals(DEFAULT_SLOT_VALUE) && !board[i][column].equals(color)) {
                position.setTopPossible(false);
                break;
            }
            if (board[i][column].equals(color)) {
                count++;
            }
        }
        if (count == 3) {
            position.setWinner(true);
        }
    }

    private static void checkRight(Position position, String[][] board) {
        int row = position.row;
        int column = position.column;
        String color = board[row][column];
        int count = 0;
        for (int i = column + 1; i <= column + 3; i++) {
            if (!board[row][i].equals(DEFAULT_SLOT_VALUE) && !board[row][i].equals(color)) {
                position.setRightPossible(false);
                break;
            }
            if (board[row][i].equals(color)) {
                count++;
            }
        }
        if (count == 3) {
            position.setWinner(true);
        }
    }

    private static void checkLeft(Position position, String[][] board) {
        int row = position.row;
        int column = position.column;
        String color = board[row][column];
        int count = 0;
        for (int i = column - 1; i >= column - 3; i--) {
            if (!board[row][i].equals(DEFAULT_SLOT_VALUE) && !board[row][i].equals(color)) {
                position.setLeftPossible(false);
                break;
            }
            if (board[row][i].equals(color)) {
                count++;
            }
        }
        if (count == 3) {
            position.setWinner(true);
        }
    }
}

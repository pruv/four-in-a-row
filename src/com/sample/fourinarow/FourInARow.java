package com.sample.fourinarow;

import java.util.Arrays;

import static com.sample.fourinarow.Position.DEFAULT_SLOT_VALUE;


public class FourInARow {

    private final static String ROW_FORMAT = "%-10s %-10s %-10s %-10s %-10s %-10s %-10s";

    private final int maxRowIdx;
    private final int maxColumnIdx;
    private boolean gameCompleted = false;
    private Player currentPlayer;

    // board header for visualization
    private final String[] boardHeader;

    // state of the game play
    private final String[][] board;

    // persists next row state for each column
    private final int[] nextRow;

    private final Player player1 = new Player("Player 1", "X");
    private final Player player2 = new Player("Player 2", "O");


    public FourInARow() {
        this(6, 7);
    }

    public FourInARow(int rowCount, int columnCount) {
        this.maxRowIdx = rowCount - 1;
        this.maxColumnIdx = columnCount - 1;
        this.board = new String[rowCount][columnCount];
        this.nextRow = new int[columnCount];
        boardHeader = new String[columnCount];

        // initialize board with default values
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                board[i][j] = DEFAULT_SLOT_VALUE;
            }
        }

        // initialize row state && board header
        for (int i = 0; i < columnCount; i++) {
            nextRow[i] = rowCount - 1;
            boardHeader[i] = String.valueOf(i);
        }
        currentPlayer = player1;
    }


    public boolean isGameCompleted() {
        return gameCompleted;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * @param column
     */
    public void playStrategy1(int column) {
        isValidMove(column);
        int rowNumber = nextRow[column];
        board[rowNumber][column] = currentPlayer.symbol;
        nextRow[column]--; // update row state for next insertion

        Position position = new Position(rowNumber, column, maxRowIdx, maxColumnIdx);

        //This strategy keeps track of the winnable positions played by each player and updates them on every turn;
        // comment out below two lines to disable strategy1
        currentPlayer.addPosition(position);
        boolean won = CheckWinningStrategy1.checkIfWinning(currentPlayer, board);

        //This strategy only depends on current position and doesn't require any track of previous positions
        // uncomment below line and comment out above two lines to pick strategy2
//        boolean won = CheckWinningStrategy2.checkIfWinning(position, board);

        if (won) {
            gameCompleted = true;
            currentPlayer.setWinner(true);
            return;
        }
        if (ifBoardIsFull()) {
            gameCompleted = true;
            return;
        }
        currentPlayer = currentPlayer == player1 ? player2 : player1; //toggle current player
    }

    private boolean ifBoardIsFull() {
        boolean full = true;
        for (int i : nextRow) {
            if (i >= 0) {
                full = false;
                break;
            }
        }
        return full;
    }

    private void isValidMove(int column) {
        if (column < 0 || column > maxColumnIdx) {
            throw new IllegalArgumentException("Please enter valid column number between 0 and " + maxColumnIdx + ".");
        }
        int rowNumber = nextRow[column];
        if (rowNumber < 0) {
            throw new IllegalArgumentException("Please enter valid column number between 0 and " + maxColumnIdx + ", column: " + column + " is full!");
        }
    }


    public void printBoard() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf((ROW_FORMAT) + "%n", boardHeader);
        System.out.println("-----------------------------------------------------------------------");
        Arrays.stream(board).map(row -> String.format(ROW_FORMAT, row)).forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------");
    }
}

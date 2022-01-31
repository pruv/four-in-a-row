package com.sample.fourinarow;

import java.util.Scanner;

public class PlayGame {

    public static void main(String[] args) {
        FourInARow fourInARow = new FourInARow(6, 7);
        fourInARow.printBoard();

        Scanner scanner = new Scanner(System.in);
        while (!fourInARow.isGameCompleted()) {
            System.out.println(fourInARow.getCurrentPlayer().name + "(" + fourInARow.getCurrentPlayer().symbol + "), please enter the column number(0-6): ");
            try {
                String input = scanner.nextLine();
                int column = Integer.parseInt(input);
                fourInARow.playStrategy1(column);
            } catch (IllegalArgumentException e) {
                System.out.println("*** ERROR: " + e.getMessage() + " ***");
            }
            fourInARow.printBoard();
        }
        if (fourInARow.getCurrentPlayer().isWinner) {
            System.out.println(fourInARow.getCurrentPlayer().name + " won the game!!");
        } else {
            System.out.println("Its a tie, well played!!");
        }
    }
}

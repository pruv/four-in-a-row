package com.sample.fourinarow;

public class Position {

    public static final String DEFAULT_SLOT_VALUE = "____";

    private boolean leftPossible = true;
    private boolean rightPossible = true;
    private boolean topPossible = true;
    private boolean leftCrossPossible = true;
    private boolean rightCrossPossible = true;
    private boolean winner = false;

    public final int row;
    public final int column;
    public final int maxRowIdx;
    public final int maxColumnIdx;

    public Position(int row, int column, int maxRowIdx, int maxColumnIdx) {
        this.row = row;
        this.column = column;
        this.maxRowIdx = maxRowIdx;
        this.maxColumnIdx = maxColumnIdx;
        if (column - 3 < 0) {
            leftPossible = false;
            leftCrossPossible = false;
        }
        if (column + 3 > maxColumnIdx) {
            rightPossible = false;
            rightCrossPossible = false;
        }
        if (row - 3 < 0) {
            topPossible = false;
            rightCrossPossible = false;
            leftCrossPossible = false;
        }
    }

    public boolean isLeftPossible() {
        return leftPossible;
    }

    public boolean isRightPossible() {
        return rightPossible;
    }

    public boolean isTopPossible() {
        return topPossible;
    }

    public boolean isLeftCrossPossible() {
        return leftCrossPossible;
    }

    public boolean isRightCrossPossible() {
        return rightCrossPossible;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setLeftPossible(boolean leftPossible) {
        this.leftPossible = leftPossible;
    }

    public void setRightPossible(boolean rightPossible) {
        this.rightPossible = rightPossible;
    }

    public void setTopPossible(boolean topPossible) {
        this.topPossible = topPossible;
    }

    public void setLeftCrossPossible(boolean leftCrossPossible) {
        this.leftCrossPossible = leftCrossPossible;
    }

    public void setRightCrossPossible(boolean rightCrossPossible) {
        this.rightCrossPossible = rightCrossPossible;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public boolean isWinnable() {
        return leftPossible || rightPossible || topPossible || leftCrossPossible || rightCrossPossible;
    }
}
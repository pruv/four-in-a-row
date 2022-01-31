package com.sample.fourinarow;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String name;
    public String symbol;
    public boolean isWinner = false;
    private final List<Position> winnablePositions = new ArrayList<>();

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public List<Position> getWinnablePositions() {
        return winnablePositions;
    }

    public void removePosition(Position position) {
        winnablePositions.remove(position);
    }

    public void addPosition(Position position) {
        winnablePositions.add(position);
    }
}
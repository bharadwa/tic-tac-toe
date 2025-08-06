package org.example.models;

public class Cell {
    private final int row;
    private final int column;
    private Player player;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.player = null;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Player getPlayer() {
        return player;
    }


}

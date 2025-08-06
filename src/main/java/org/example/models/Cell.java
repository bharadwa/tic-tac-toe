package org.example.models;

import org.example.enums.CellState;

public class Cell {
    private final int row;
    private final int column;
    private CellState cellState;
    private static final String EMPTY_CHARACTER="-";

    private Player player;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.player = null;
        this.cellState = CellState.EMPTY;
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

    public void display()  {
        System.out.print("| "+ (this.cellState == CellState.FILLED?this.player.getCharacter():EMPTY_CHARACTER) + " |");
    }

}

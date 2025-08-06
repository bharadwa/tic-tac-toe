package org.example.models;

import org.example.constants.GameConstants;
import org.example.enums.CellState;

public class Cell {

    private final int row;
    private final int column;
    private CellState cellState;
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

    public void display() {
        System.out.print("| " + (this.cellState == CellState.FILLED ? this.player.getCharacter() : GameConstants.EMPTY_CHARACTER) + " |");
    }

    public boolean isValid() {
        return this.cellState != CellState.FILLED;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public CellState getCellState() {
        return cellState;
    }
}

package org.example.models;

import java.util.ArrayList;
import java.util.List;

//all the variables should be private we need to create getters and setters for them
public class Board {

    private List<List<Cell>> cells;

    private final int dimension;

    public Board(int dimension) {
        this.dimension = dimension;
        this.cells = initCells(dimension);
    }

    private List<List<Cell>> initCells(int dimension) {

        List<List<Cell>> cells = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < dimension; j++) {
                row.add(new Cell(i, j)); // Assuming Cell constructor takes row, column, and player
            }
            cells.add(row);
        }
        return cells;

    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public Cell getCell(int row,int columns) {
        return cells.get(row).get(columns);
    }

    public int getDimension() {
        return dimension;
    }

    public void updateBoard(Cell cell) {
      getCell(cell.getRow(),cell.getColumn()).setCellState(cell.getCellState());
      getCell(cell.getRow(),cell.getColumn()).setPlayer(cell.getPlayer());
    }
}

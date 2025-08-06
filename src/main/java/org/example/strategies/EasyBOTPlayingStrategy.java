package org.example.strategies;

import org.example.enums.CellState;
import org.example.models.Board;
import org.example.models.Cell;

import java.util.List;

public class EasyBOTPlayingStrategy implements BOTPlayingStrategy {


    @Override
    public Cell makeMove(Board board) {
        List<List<Cell>> cells = board.getCells();
        for(List<Cell> row : cells){
            for(Cell cell : row){
                if(cell.getCellState()== CellState.EMPTY){
                    return new Cell(cell.getRow(),cell.getColumn());
                }
            }
        }
        return null;
    }
}

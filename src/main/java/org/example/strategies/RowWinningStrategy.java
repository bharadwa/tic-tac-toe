package org.example.strategies;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.Move;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements GameWinningStrategy {

    private final Map<Integer, Map<String,Integer>> rowMap=new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        Cell cell =move.getCell();
        int row=cell.getRow();
        if(!rowMap.containsKey(row)){
            rowMap.put(row,new HashMap<>());
        }
        Map<String,Integer> symbolMap= rowMap.get(row);
        String symbol=move.getPlayer().getCharacter();
        symbolMap.put(symbol,symbolMap.getOrDefault(symbol,0)+1);
        rowMap.put(cell.getRow(),symbolMap);
        return rowMap.get(row).get(symbol)==board.getDimension();
    }
}

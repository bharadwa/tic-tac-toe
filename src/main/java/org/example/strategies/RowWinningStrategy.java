package org.example.strategies;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.Move;
import org.example.models.Player;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements GameWinningStrategy {

    private final Map<Integer, Map<String,Integer>> rowMap=new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int row=getRow(move.getCell());
        if(!rowMap.containsKey(row)){
            rowMap.put(row,new HashMap<>());
        }
        Map<String,Integer> symbolMap= rowMap.get(row);
        String symbol=getSymbol(move.getPlayer());
        symbolMap.put(symbol,symbolMap.getOrDefault(symbol,0)+1);
        rowMap.put(row,symbolMap);
        return rowMap.get(row).get(symbol)==board.getDimension();
    }
    private int getRow(Cell cell) {
        return cell.getRow();
    }

    @Override
    public void undoMove(Move lastMove,int size) {
        int row=getRow(lastMove.getCell());
        String symbol=getSymbol(lastMove.getPlayer());
        rowMap.get(row).put(symbol,rowMap.get(row).get(symbol)-1);
    }

    private String getSymbol(Player player) {
         return player.getCharacter();
    }
}

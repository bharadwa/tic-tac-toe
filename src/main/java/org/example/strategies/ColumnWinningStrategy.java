package org.example.strategies;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.Move;
import org.example.models.Player;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements GameWinningStrategy{

    private final Map<Integer, Map<String,Integer>> colMap=new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int col=getColumn(move.getCell());
        if(!colMap.containsKey(col)){
            colMap.put(col,new HashMap<>());
        }
        Map<String,Integer> symbolMap= colMap.get(col);
        String symbol=getSymbol(move.getPlayer());
        symbolMap.put(symbol,symbolMap.getOrDefault(symbol,0)+1);
        colMap.put(col,symbolMap);
        return colMap.get(col).get(symbol)==board.getDimension();
    }
    private int getColumn(Cell cell) {
        return cell.getColumn();
    }

    @Override
    public void undoMove(Move lastMove,int size) {
        int col=getColumn(lastMove.getCell());
        String symbol=getSymbol(lastMove.getPlayer());
        colMap.get(col).put(symbol,colMap.get(col).get(symbol)-1);
    }

    private String getSymbol(Player player) {
        return player.getCharacter();
    }
}

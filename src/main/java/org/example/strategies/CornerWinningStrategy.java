package org.example.strategies;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.Move;
import org.example.models.Player;

import java.util.HashMap;
import java.util.Map;

public class CornerWinningStrategy implements  GameWinningStrategy{

    private final Map<String,Integer> cornerMap=new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int row=getRow(move.getCell());
        int col=getCol(move.getCell());
        int size=board.getDimension();
        String symbol=getSymbol(move.getPlayer());
        if(isValidCell(row,col,size)){
            cornerMap.put(symbol,cornerMap.getOrDefault(symbol,0)+1);
            return cornerMap.get(symbol)==4;
        }

        return false;
    }

    private boolean isValidCell(int row,int col,int size){
        return row==0 && col==0||row==0&&col==size-1||row==size-1&&col==size-1||row==size-1&&col==0;
    }

    private String getSymbol(Player player) {
        return player.getCharacter();
    }

    private int getRow(Cell cell) {
        return cell.getRow();
    }
    private int getCol(Cell cell) {
        return cell.getColumn();
    }

    @Override
    public void undoMove(Move move, int size) {
        int row=getRow(move.getCell());
        int col=getCol(move.getCell());
        String symbol=getSymbol(move.getPlayer());
        if(isValidCell(row,col,size)){
            cornerMap.put(symbol,cornerMap.get(symbol)-1);
        }
    }
}

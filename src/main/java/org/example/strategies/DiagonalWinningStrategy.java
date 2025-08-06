package org.example.strategies;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.Move;
import org.example.models.Player;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements GameWinningStrategy{

    private final Map<Integer, Map<String,Integer>> diagonalMap=new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {
        int row=getRow(move.getCell());
        int col=getCol(move.getCell());
        int size=board.getDimension();
        String symbol=getSymbol(move.getPlayer());
        if(row==col) {
            Map<String,Integer> principalDiagonalMap=diagonalMap.get(0);
            if(principalDiagonalMap==null||principalDiagonalMap.isEmpty()) {
                principalDiagonalMap=new HashMap<>();
            }
            principalDiagonalMap.put(symbol,principalDiagonalMap.getOrDefault(symbol,0)+1);
            diagonalMap.put(0,principalDiagonalMap);

            return principalDiagonalMap.get(symbol)==size;

        }else if (size - 1 == (row + col)) {
            Map<String,Integer> secondaryDiagonalMap=diagonalMap.get(1);

            if(secondaryDiagonalMap==null||secondaryDiagonalMap.isEmpty()) {
                secondaryDiagonalMap=new HashMap<>();
            }
            secondaryDiagonalMap.put(symbol,secondaryDiagonalMap.getOrDefault(symbol,0)+1);
            diagonalMap.put(0,secondaryDiagonalMap);

            return secondaryDiagonalMap.get(symbol)==size;

        }else {
            return false;
        }

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
    public void undoMove(Move move,int size) {
        int row=getRow(move.getCell());
        int col=getCol(move.getCell());
        String symbol=getSymbol(move.getPlayer());
        if(row==col) {
            diagonalMap.get(0).put(symbol,diagonalMap.get(0).get(symbol)-1);

        }else if (size - 1 == (row + col)) {
            diagonalMap.get(1).put(symbol,diagonalMap.get(1).get(symbol)-1);
        }
    }
}

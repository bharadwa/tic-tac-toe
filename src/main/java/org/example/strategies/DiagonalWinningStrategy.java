package org.example.strategies;

import org.example.models.Board;
import org.example.models.Move;

public class DiagonalWinningStrategy implements GameWinningStrategy{

    @Override
    public boolean checkWinner(Move move, Board board) {
        return false;
    }
}

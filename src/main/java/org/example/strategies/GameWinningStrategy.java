package org.example.strategies;

import org.example.models.Board;
import org.example.models.Move;

public interface GameWinningStrategy {

    boolean checkWinner(Move move, Board board);

    void undoMove(Move lastMove,int size);
}

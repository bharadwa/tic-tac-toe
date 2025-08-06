package org.example.strategies;

import org.example.models.Board;
import org.example.models.Cell;

public interface BOTPlayingStrategy {

    Cell makeMove(Board board);


}

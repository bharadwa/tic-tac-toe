package org.example.models;

import org.example.enums.CellState;
import org.example.enums.DifficultyLevel;
import org.example.enums.PlayerType;
import org.example.factories.BOTPlayingStrategyFactory;
import org.example.strategies.BOTPlayingStrategy;

import java.util.List;

public class BOT extends Player {

    private final DifficultyLevel difficultyLevel;

    private BOTPlayingStrategy botPlayingStrategy;

    public BOT(String name, Symbol symbol, DifficultyLevel difficultyLevel) {
        super(name, symbol, PlayerType.BOT);
        this.difficultyLevel = difficultyLevel;
        this.botPlayingStrategy = BOTPlayingStrategyFactory.createBOTPlayingStrategy(this.difficultyLevel);
    }

    @Override
    public Cell makeMove(Board board) {
        System.out.println("BOT :"+this.getCharacter()+ " is making move");
        return botPlayingStrategy.makeMove(board);
    }
}

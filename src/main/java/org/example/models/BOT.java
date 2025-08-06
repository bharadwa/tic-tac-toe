package org.example.models;

import org.example.enums.DifficultyLevel;
import org.example.enums.PlayerType;
import org.example.strategies.BOTPlayingStrategy;

public class BOT extends Player {

    private final DifficultyLevel difficultyLevel;

    private BOTPlayingStrategy botPlayingStrategy;

    public BOT(String name, Symbol symbol, DifficultyLevel difficultyLevel) {
        super(name, symbol, PlayerType.BOT);
        this.difficultyLevel = difficultyLevel;
    }

}

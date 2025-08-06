package org.example.factories;

import org.example.enums.DifficultyLevel;
import org.example.strategies.BOTPlayingStrategy;

public class BOTPlayingStrategyFactory {

    public static BOTPlayingStrategy createBOTPlayingStrategy(DifficultyLevel difficultyLevel) {
        switch (difficultyLevel) {
            case EASY -> {
                return new org.example.strategies.EasyBOTPlayingStrategy();
            }
            case MEDIUM -> {
                return new org.example.strategies.MediumBOTPlayingStrategy();
            }
            case HARD -> {
                return new org.example.strategies.HardBOTPlayingStrategy();
            }
        }
        return null;
    }
}

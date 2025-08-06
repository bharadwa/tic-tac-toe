package org.example.factories;

import org.example.enums.WinningStrategyType;
import org.example.strategies.ColumnWinningStrategy;
import org.example.strategies.DiagonalWinningStrategy;
import org.example.strategies.GameWinningStrategy;
import org.example.strategies.RowWinningStrategy;

public class WinningStrategyFactory {

    public static GameWinningStrategy getWinningStrategy(String strategy) {

        WinningStrategyType type = WinningStrategyType.convert(strategy);
        switch (type) {
            case DIAGONAL:
                return new DiagonalWinningStrategy();
            case ROW:
                return new RowWinningStrategy();
            case COLUMN:
                return new ColumnWinningStrategy();
            default:
                throw new IllegalArgumentException("Invalid strategy type");
        }

    }
}

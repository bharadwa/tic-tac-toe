package org.example.factories;

import org.example.enums.WinningStrategyType;
import org.example.strategies.*;

public class WinningStrategyFactory {

    public static GameWinningStrategy getWinningStrategy(String strategy) {

        WinningStrategyType type = WinningStrategyType.convert(strategy);
        if(type==null) {
            throw new IllegalArgumentException("Invalid strategy provided: "+strategy +" Please provide valid ROW|COLUMN|DIAGONAL");
        }
        switch (type) {
            case DIAGONAL:
                return new DiagonalWinningStrategy();
            case ROW:
                return new RowWinningStrategy();
            case COLUMN:
                return new ColumnWinningStrategy();
            case CORNER :
                return new CornerWinningStrategy();
            default:
                throw new IllegalArgumentException("Invalid strategy type");
        }

    }
}

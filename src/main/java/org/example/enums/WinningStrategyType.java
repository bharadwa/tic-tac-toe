package org.example.enums;

import org.example.utils.StringUtils;

public enum WinningStrategyType {

    ROW,
    COLUMN,
    DIAGONAL;


    public static WinningStrategyType convert(String strategyType) {

        if (StringUtils.isEmpty(strategyType)) {
            return WinningStrategyType.ROW;
        }

        for (WinningStrategyType winningStrategyType : WinningStrategyType.values()) {
            if (strategyType.toUpperCase().equals(winningStrategyType.name())) {
                return winningStrategyType;
            }
        }
        return null;
    }
}

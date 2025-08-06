package org.example.enums;

import org.example.utils.StringUtils;

public enum DifficultyLevel {

    EASY,
    MEDIUM,
    HARD;

    public static DifficultyLevel build(String difficultLevel) {
        if (StringUtils.isEmpty(difficultLevel)) {
            throw new RuntimeException("Please provide valid difficulty level EASY OR MEDIUM OR HARD");
        }
        for (DifficultyLevel d : DifficultyLevel.values()) {
            if (d.name().equals(difficultLevel.toUpperCase())) {
                return d;
            }
        }
        throw new RuntimeException("Please provide valid difficulty level EASY OR MEDIUM OR HARD");
    }

}

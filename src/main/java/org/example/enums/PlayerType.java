package org.example.enums;

import org.example.utils.StringUtils;

public enum PlayerType {

    BOT,
    HUMAN;

    public static PlayerType build(String playerType) {
        if (StringUtils.isEmpty(playerType)) {
            throw new RuntimeException("player Type cant be blank please input either BOT|HUMAN");
        }
        for (PlayerType p : PlayerType.values()) {
            if (p.name().equals(playerType.toUpperCase())) {
                return p;
            }
        }
        throw new RuntimeException("player Type cant be blank please input either BOT|HUMAN");
    }
}

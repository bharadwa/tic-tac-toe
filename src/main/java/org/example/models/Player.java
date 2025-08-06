package org.example.models;

import org.example.enums.PlayerType;

public class Player {

    private final String name;

    private final Symbol symbol;

    private final PlayerType playerType;

    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getName() {
        return this.name;
    }

    public Symbol getSymbol() {
        return this.symbol;
    }

    public PlayerType getPlayerType() {
        return this.playerType;
    }

    public String getCharacter() {
        return getSymbol().getSymbol();
    }
}

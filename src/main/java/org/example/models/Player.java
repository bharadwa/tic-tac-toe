package org.example.models;

import org.example.enums.PlayerType;

import java.util.Scanner;

public class Player {

    public static final Scanner sc = new Scanner(System.in);

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

    public Cell makeMove() {
        System.out.println("Please provide the row for the move ");
        int row = sc.nextInt();
        System.out.println("Please provide the column for the move ");
        int column = sc.nextInt();
        return new Cell(row, column);
    }
}

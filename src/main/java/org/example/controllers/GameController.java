package org.example.controllers;

import org.example.enums.GameState;
import org.example.models.Game;
import org.example.models.Player;
import org.example.strategies.GameWinningStrategy;

import java.util.List;

public class GameController {

    public Game StartGame(int dimension, List<Player> players, List<GameWinningStrategy> winningStrategies) {
        Game game = Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();

        return game;
    }

    public GameState getGameState(Game game) {
        return game.getGameState();
    }

    public void displayBoard(Game game) {
        game.displayBoard();
    }


    public void makeMove(Game game) {
        game.makeMove();
        //
    }

    public void undoMove(Game game) {
        game.undoMove();
    }
}

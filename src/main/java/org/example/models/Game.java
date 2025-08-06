package org.example.models;

import org.example.enums.GameState;
import org.example.strategies.GameWinningStrategy;

import java.util.List;

public class Game {

    private List<Player> players;

    private Board board;

    private int currentPlayerIndex;

    private GameState gameState;

    private Player winner;

    private List<GameWinningStrategy> winningStrategies;

    public Game(List<Player> players, int dimension, List<GameWinningStrategy> winningStrategies) {
        this.players = players;
        this.board = new Board(dimension);
        this.winningStrategies = winningStrategies;
        this.currentPlayerIndex = 0;
        this.gameState = GameState.NOT_STARTED;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public GameState getGameState() {
        return gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public List<GameWinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void displayBoard() {
        for (List<Cell> row : board.getCells()) {
            row.stream().forEach(cell->cell.display());
            System.out.println();
        }
    }
}

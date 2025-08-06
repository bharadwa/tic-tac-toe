package org.example.models;

import org.example.enums.CellState;
import org.example.enums.GameState;
import org.example.strategies.GameWinningStrategy;
import org.example.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players;

    private Board board;

    private int currentPlayerIndex;

    private GameState gameState;

    private Player winner;

    private List<GameWinningStrategy> winningStrategies;

    private List<Move> moves;

    public Game(List<Player> players, int dimension, List<GameWinningStrategy> winningStrategies) {
        this.players = players;
        this.board = new Board(dimension);
        this.winningStrategies = winningStrategies;
        this.currentPlayerIndex = 0;
        this.gameState = GameState.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.winner = null;
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
            row.stream().forEach(cell -> cell.display());
            System.out.println();
        }
    }

    public void makeMove() {

        //if game state is in progress then only move is allowed
        if (gameState != GameState.IN_PROGRESS) {
            throw new IllegalStateException("Game state is not IN_PROGRESS");
        }
        Player currentPlayer = players.get(currentPlayerIndex);
        Cell cell = currentPlayer.makeMove();
        if (!validateMove(cell)) {
            System.out.println("this is a invalid move please entire a valid move ");
            return;
        }
        cell.setPlayer(currentPlayer);
        cell.setCellState(CellState.FILLED);
        Move move = new Move(cell, currentPlayer);
        //update the move to the board
        this.board.updateBoard(cell);
        moves.add(move);
        //check the winning strategies and then
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        if (checkWinner(move, this.board)) {
            this.gameState = GameState.PLAYER_WON;
            this.winner = currentPlayer;
        } else if (moves.size() == board.getDimension() * board.getDimension()) {
            this.gameState = GameState.DRAW;
        }
    }

    public boolean checkWinner(Move move, Board board) {
        for (GameWinningStrategy strategy : winningStrategies) {
            if (strategy.checkWinner(move, board)) {
                return true;
            }
        }
        return false;
    }


    private boolean validateMove(Cell cell) {
        if (cell.getRow() < 0 || cell.getRow() >= board.getDimension()) {
            System.out.println("Invalid row");
            return false;
        }
        if (cell.getColumn() < 0 || cell.getColumn() >= board.getDimension()) {
            System.out.println("Invalid column");
            return false;
        }
        // check this cell state in the board if it is already filled
        return this.getBoard().getCell(cell.getRow(), cell.getColumn()).isValid();
    }

    public void undoMove() {
        if (CollectionUtils.isEmpty(this.moves)) {
            System.out.println("No more moves");
            return;
        }
        Move lastMove = moves.get(moves.size() - 1);
        //remove the last move from the board
        this.board.undoMove(lastMove);
        //undo the winning strategies map
        for (GameWinningStrategy strategy : winningStrategies) {
            strategy.undoMove(lastMove);
        }
        currentPlayerIndex = (currentPlayerIndex - 1) % players.size();
        //update the game State
        this.winner = null;
        this.gameState = GameState.IN_PROGRESS;
        //remove the last move at the end
        moves.remove(lastMove);
    }
}

package org.example.client;

import org.example.controllers.GameController;
import org.example.enums.GameState;
import org.example.enums.PlayerType;
import org.example.factories.WinningStrategyFactory;
import org.example.models.Board;
import org.example.models.Game;
import org.example.models.Player;
import org.example.models.Symbol;
import org.example.strategies.GameWinningStrategy;
import org.example.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameClient {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        GameController controller = new GameController();
        System.out.println("start the game:");

        System.out.println("please enter the size of the board:");
        int dimension =input.nextInt();
        System.out.println("please enter the winning strategies of the board like ROW,COLUMN,DIAGONAL,CORNER:");
        String winningStrategy = input.next();
        String strategies[] =winningStrategy.split(",");
        List<GameWinningStrategy> winningStrategies = new ArrayList<>();
        for(String strategy:strategies){
            winningStrategies.add(WinningStrategyFactory.getWinningStrategy(strategy));
        }

        int playersCount=dimension-1;
        List<Player> players= new ArrayList<>();
        for(int index=0;index < playersCount; index++){
            System.out.println("Please enter the name of the player :"+(index+1)+":");
            String name=input.next();
            System.out.println("Please enter the symbol :"+(index+1)+":");
            String symbol=input.next();
            players.add(new Player(name,new Symbol(symbol), PlayerType.HUMAN));
        }

        Game game=controller.StartGame(dimension,players,winningStrategies);
        controller.displayBoard(game);
        while(controller.getGameState(game)== GameState.IN_PROGRESS){
            controller.makeMove(game);
            controller.displayBoard(game);
            // next we check for undo
            System.out.println("Do you want to undo a move please select y/n");
            String undo=input.next();
            if(StringUtils.isNotEmpty(undo)&&undo.equals("y")){
              controller.undoMove(game);
              controller.displayBoard(game);
            }
        }

        if(game.getGameState()==GameState.PLAYER_WON) {
            System.out.println("current winner of the game :"+game.getWinner().getName());
        }else if (game.getGameState()==GameState.BOT_WON) {
            System.out.println("current winner of the game is Bot :"+game.getWinner().getName());
        } else if(game.getGameState()==GameState.DRAW){
            System.out.println("Game is ended in a draw state :");
        }

    }
}

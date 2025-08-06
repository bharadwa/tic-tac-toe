package org.example.client;

import org.example.controllers.GameController;
import org.example.enums.PlayerType;
import org.example.factories.WinningStrategyFactory;
import org.example.models.Game;
import org.example.models.Player;
import org.example.models.Symbol;
import org.example.strategies.GameWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameClient {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        GameController controller = new GameController();
        System.out.println("start the game");

        System.out.println("please enter the size of the board");
        int dimension =input.nextInt();
        System.out.println("please enter the winning strategies of the board");
        String winningStrategy = input.next();
        String strategies[] =winningStrategy.split(",");
        List<GameWinningStrategy> winningStrategies = new ArrayList<>();
        for(String strategy:strategies){
            winningStrategies.add(WinningStrategyFactory.getWinningStrategy(strategy));
        }

        int playersCount=dimension-1;
        List<Player> players= new ArrayList<>();
        for(int index=0;index<playersCount;index++){
            System.out.println("Please enter the name of the player "+(index+1)+":");
            String name=input.next();
            System.out.println("please enter the symbol "+(index+1)+":");
            String symbol=input.next();
            players.add(new Player(name,new Symbol(symbol), PlayerType.HUMAN));
        }

        Game game=controller.StartGame(dimension,players,winningStrategies);
        controller.displayBoard(game);
    }
}

package io.zipcoder.casino;

import io.zipcoder.casino.CardGame.BlackJack;
import io.zipcoder.casino.CardGame.GoFishGame;
import io.zipcoder.casino.GameInterface.DiceGame.ChoHanGame;
import io.zipcoder.casino.GameInterface.DiceGame.CrapsGame;
import io.zipcoder.casino.Player.*;
import io.zipcoder.casino.utilities.Console;

import javax.swing.text.PlainDocument;
import java.io.InputStream;
import java.util.Scanner;

public class CasinoEngine {
    Player currentPlayer;
    Console myConsole;

    public CasinoEngine(){
        currentPlayer = new Player("Player1");
        myConsole = new Console(System.in,System.out);
    }

    public void run(){
        while(true){
            String gameSelection = myConsole.getStringInput("Hi "+currentPlayer.getName()+"!\nWhat game would you like to play?\n1. BlackJack\n2. Craps\n3. ChoHan\n4. Go Fish\n99. Quit");
            if (gameSelection.equals("1")){
                runBlackJackGame(currentPlayer);
            }
            else if(gameSelection.equals("2")){
                runCraps(currentPlayer);
            }
            else if(gameSelection.equals("3")){
                runChoHan(currentPlayer);
            }
            else if(gameSelection.equals("4")){
                runGoFish(currentPlayer);
            }
            else if(gameSelection.equals("99")){
                System.exit(0);
            }
        }
    }

    public void runBlackJackGame(Player currentPlayer){
        System.out.print("Entering BlackJack\n\n");
        BlackJack blackJack = new BlackJack(currentPlayer);
        blackJack.startGame();

    }

    public void runGoFish(Player currentPlayer){
        System.out.print("Entering Go Fish\n\n");
        GoFishGame goFish = new GoFishGame(currentPlayer);
        goFish.startGame();
    }

    public void runCraps(Player currentPlayer){
        System.out.print("Entering Craps\n\n");
        CrapsGame craps = new CrapsGame(currentPlayer);
    }

    public void runChoHan(Player currentPlayer){
        System.out.print("Entering Cho Han\n\n");
        ChoHanGame choHan = new ChoHanGame(currentPlayer);
    }



}

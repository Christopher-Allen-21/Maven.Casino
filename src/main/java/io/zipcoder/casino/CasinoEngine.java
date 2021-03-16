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
        //May cause issues return player to main screen
        BlackJackPlayer blackJackPlayer = (BlackJackPlayer) currentPlayer;
        BlackJack blackJack = new BlackJack(blackJackPlayer);
    }

    public void runGoFish(Player currentPlayer){
        System.out.print("Entering Go Fish\n\n");
        //May cause issues return player to main screen
        GoFishPlayer goFishPlayer = (GoFishPlayer) currentPlayer;
        GoFishGame goFish = new GoFishGame(goFishPlayer);
        goFish.startGame();
    }

    public void runCraps(Player currentPlayer){
        System.out.print("Entering Craps\n\n");
        //May cause issues return player to main screen
        CrapsPlayer crapsPlayer = (CrapsPlayer) currentPlayer;
        CrapsGame craps = new CrapsGame();
    }

    public void runChoHan(Player currentPlayer){
        System.out.print("Entering Cho Han\n\n");
        //May cause issues return player to main screen
        ChoHanPlayer choHanPlayer = (ChoHanPlayer) currentPlayer;
        ChoHanGame choHan = new ChoHanGame();
    }



}

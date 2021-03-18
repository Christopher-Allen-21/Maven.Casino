package io.zipcoder.casino.GameInterface.DiceGame;

import io.zipcoder.casino.Dice;
import io.zipcoder.casino.GameInterface.GamblingGameInterface;
import io.zipcoder.casino.GameInterface.GameInterface;
import io.zipcoder.casino.Player.GamblingPlayer;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;

import static jdk.nashorn.internal.objects.Global.println;

public class ChoHanGame implements GameInterface {




    private Console myConsole = new Console(System.in, System.out);

    private GamblingPlayer player1;
    private int rollValue;
    private double playerBet = 0.0;
    private String playerChoice;  // even or odd
    private boolean diceOddEven;  // true for odd, false for even

    private Dice playerDice = new Dice();

    public ChoHanGame(GamblingPlayer player1) {
        this.player1 = player1;
    }


    public void startGame() {
        boolean redo = true;
        greetPlayer();
        do {
            askEvenOdd();
            askWager();

            askRollDice();
    //            //printasciArt();
    //            //and value
            ifOdd();
            checkWinner();
    //            setPlayerBalance();
    //            displaySummary();
            redo = myConsole.displayPlayAgain("Cho-Han"); // Cho-Han
            } while (redo);
    //            quitGame();
    //            cashOut();
    //            collectWinnings();

    }


    public void greetPlayer () {
        System.out.println("Welcome to Cho-Han!");
    }

    public void askEvenOdd () {
        System.out.println("\nPlace your bet: Even or Odd?");
        boolean redo = true;
        while (redo) {
            playerChoice = myConsole.getStringInput("Enter even or odd");
            if (playerChoice.equalsIgnoreCase("even")) {
                playerChoice = "even";
                redo = false;
            } else if (playerChoice.equals("odd")) {
                playerChoice = "odd";
                redo = false;
            } else {
                myConsole.getDoubleInput("Please enter 1 or 2"); // testing if 1 or 2
            }
        }
    }

    public void askWager () {
        playerBet = myConsole.getDoubleInput("How much would you like to bet? Enter dollar amount.");
        player1.placeBet(playerBet);
                System.out.println("You have wagered $" + playerBet + "\n");
    }


    public int askRollDice () {
        System.out.println("Are you ready to roll?");
        boolean redo = true;
        String playerRolls;
        while (redo) {
            playerRolls = myConsole.getStringInput("Enter 1 to roll dice");
            if (playerRolls.equals("1")) {
                rollValue = playerDice.rollPairDice(); // Display dice - make display dice method.
                redo = false;
            } else {
                myConsole.getDoubleInput("Enter 1 to roll dice"); // testing if 1 or 2
            }
            System.out.println("You have rolled a " + rollValue + "!");
        }   return rollValue;
    }

//    public void displayDice() {
//        getDie1Image();
//        getDie2Image();
//
//    }
//    public void getDie1Image() {} // ASCI art of the two dice
//
//    public void getDie2Image() {} // ASCI art of the two dice

    public void ifOdd () {
        if (rollValue % 2 != 0) {
            System.out.println("\nYou rolled Odd");
            diceOddEven = true;  // true if roll is odd
        } else {
            System.out.println("\nYou rolled Even");
            diceOddEven = false;  // false if roll is even
        }
    }

    @Override
    public void checkWinner () { // possibly use .checkWinner here from Game Interface
        if (playerChoice.equalsIgnoreCase("odd") && diceOddEven) {
            System.out.println("Congratulations, you win!");
            //playerWinsBet ();
        } else if (playerChoice.equalsIgnoreCase("even") && !diceOddEven) {
            System.out.println("Congratulations, you win!");
            //playerWinsBet ();
        } else {
            System.out.println("Sorry, you lost! Better luck next time.\n");
            //playerLosesBet ();
        }
    }


}


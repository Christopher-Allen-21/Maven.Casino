package io.zipcoder.casino.GameInterface.DiceGame;

import io.zipcoder.casino.Dice;
import io.zipcoder.casino.GameInterface.GamblingGameInterface;
import io.zipcoder.casino.GameInterface.GameInterface;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;

import java.sql.SQLOutput;

public class ChoHanGame implements GameInterface, GamblingGameInterface {


    private Console myConsole = new Console(System.in, System.out);
    private Player player1;
    private int rollValue;
    private double playerBet = 0.0;
    private String playerChoice;  // even or odd
    private boolean diceOddEven;  // true for odd, false for even
    private Dice playerDice = new Dice();


    public ChoHanGame(Player player1) {
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
            displayPlayerBalance();
            redo = myConsole.displayPlayAgain("Cho-Han"); // Cho-Han
            } while (redo);

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
                playerChoice = "Even";
                redo = false;
            } else if (playerChoice.equalsIgnoreCase("odd")) {
                playerChoice = "Odd";
                redo = false;
            } else {
                myConsole.getDoubleInput("Please enter even or odd");
            }
        }
    }

    public void askWager () {
        double playerCurrentBalance = player1.getPlayerBalance();
        boolean redo = true;
        while (redo) {
            playerBet = myConsole.getDoubleInput("How much would you like to bet? Enter dollar amount.");
            if (playerCurrentBalance < playerBet) {
                System.out.println("Sorry, you don't have enough to wager that.");
                redo = true;
            } else {
                player1.placeBet(playerBet);
                System.out.println("You have wagered $" + playerBet + "\n");
                redo = false;
            }
        }

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
            System.out.println("\nYou rolled Odd, and you bet on " + playerChoice + ".\n");
            diceOddEven = true;  // true if roll is odd
        } else {
            System.out.println("\nYou rolled Even, and you bet on " + playerChoice + ".\n");
            diceOddEven = false;  // false if roll is even
        }
    }


    public void checkWinner () { // possibly use .checkWinner here from Game Interface
        if (playerChoice.equalsIgnoreCase("odd") && diceOddEven) {
            System.out.println("Congratulations, you win!");
            playerWinsBet();
        } else if (playerChoice.equalsIgnoreCase("even") && !diceOddEven) {
            System.out.println("Congratulations, you win!");
            playerWinsBet ();
        } else {
            System.out.println("Sorry, you lost! Better luck next time.\n");
        }

    }

    public void playerWinsBet() {
        player1.collectWinnings(playerBet);
    }

    public void displayPlayerBalance() {
       System.out.println("Your current balance is: $" + player1.getPlayerBalance());
    }



}


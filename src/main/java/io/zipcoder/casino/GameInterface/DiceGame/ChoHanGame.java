package io.zipcoder.casino.GameInterface.DiceGame;

import io.zipcoder.casino.Dice;
import io.zipcoder.casino.GameInterface.GameInterface;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;

import static jdk.nashorn.internal.objects.Global.println;

public class ChoHanGame implements GameInterface {
    private Console myConsole = new Console(System.in,System.out);

    private Player player1;
    private int rollValue;
    private double playerBet;
    private int playerChoice;  // 1 for odd, 2 for even
    private boolean diceOddEven;  // true for odd, false for even

    private Dice playerDice = new Dice();

    public ChoHanGame(Player player1) {
        this.player1 = player1;
    }


    /*
    public void startGame(){

        while(true) {
            greetPlayer();
            askEvenOrOdd();
            askWager();
                placeBet()
            rollDice();
            printasciArt(); and value
            checkEvenOrOdd();
            checkWinLoss();
            reportWinLoss();
            setPlayerBalance();
            displaySummary();
            askPlayAgain();
            quitGame();
                cashOut();
                collectWinnings();

        }
    */


    public void greetPlayer() {
        System.out.println("Welcome to Cho-Han!");
    }

    public boolean askEvenOdd() {
        System.out.println("Place your bet: Even or Odd?");
        String playerChoice = "";
        // put in while loop
        playerChoice = myConsole.getStringInput("Select 1 for 'odd', Select 2 for 'even'");
        if (playerChoice.equals("1")) {
            // note odd - save to variable?
        } else if (playerChoice.equals("2")) {
            // note even - save to variable? an int 1 or 2
        }
        else {
            getStringInput("Please enter 1 or 2"); // testing if 1 or 2
        }
    }

    public void askWager() {
        playerBet = myConsole.getDoubleInput("How much would you like to bet? Enter dollar amount.");
        player1.placeBet(); // askWager method same as placeBet method of Gambling player superclass? need to override?
        //need to extend gambling player class to player
        //System.out.printf("%8.2f", x); - print in money format
        //System.out.printf("Hello, %s. Next year, you'll be %d", name, age); format with multiple args and multiple formats
        System.out.printf("You have wagered %8.2F", playerBet); // need to doublecheck formatting on this, maybe just use "You have wagered $" + playerBet + ".00."
    }

    public int askRollDice() { // needs tweaks
        System.out.println("Are you ready to roll?");
        while (true) {
            String playerChoice = myConsole.getStringInput("Enter 1 to roll dice");
            if (playerChoice.equals("1")) {
                rollValue = playerDice.rollPairDice(); // Display dice - make display dice method.
                return rollValue;
            }
            else {
                playerChoice = myConsole.getStringInput("You must enter 1 to roll the dice.");
            }
        }
    }

    public void displayDice() {
        getDie1Image();
        getDie2Image();

    }
    public void getDie1Image() {} // ASCI art of the two dice

    public void getDie2Image() {} // ASCI art of the two dice

    public boolean ifOdd() {
        if (rollValue % 2 != 0) {
            return true;          // true if roll odd
        } else {
            return false;         // false if roll even
        }
    }
    public boolean getWinLoss() { // possibly use .checkWinner here from Game Interface
        if (playerChoice == 1 && ifOdd()) {
            System.out.println("Congratulations, you win!");
            return true;
        } else if (playerChoice == 2 && ifOdd()) {
            System.out.println("Congratulations, you win!");
            return true;
        }
        else {
            System.out.println("Sorry, you lost! Better luck next time.");
            return false;

        }
    }
    public int askPlayAgain() {
        System.out.println("Would you like to play again?");
        String playerChoice = myConsole.getStringInput("Enter 1 play again or 2 to exit to the Casino."); // should new variable get declared here? or can reuse playChoice.
        if (playerChoice.equals("1")) {
            // start loop of .startGame() over again
        }
        else if (playerChoice.equals("2")) {
            //
        }
        else {
        }   return -1;
    }



    public void compareTotals () {
    }

    public void playerLosesBet () {
    }
    public void playerWinsBet () {
    }
    public void playerHasNoMoney () {
    }

    public void checkWinner() {

    }

}

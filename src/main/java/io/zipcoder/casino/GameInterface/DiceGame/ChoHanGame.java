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
    private Dice playerDice = new Dice();

    public void greetPlayer() {
        System.out.println("Welcome to Cho Han!");
    }

    public void askEvenOdd() {
        System.out.println("Place your bet: Even or Odd?");
        String playerChoice = "";
        playerChoice = myConsole.getStringInput("Select 1 for 'odd', Select 2 for 'even'");
        if (playerChoice.equals("1")) {
            // note odd - save to variable?
        } else if (playerChoice.equals("2")) {
            // note even - save to variable?
        }
        else {
            //getStringInput("Please enter 1 or 2");
        }
    }

    public void askWager() {
        Double playerBet = myConsole.getDoubleInput("How much would you like to bet? Enter dollar amount.");
        //player1.placeBet(); // askWager method same as placeBet method of Gambling player superclass? need to override?
        //System.out.printf("%8.2f", x); - print in money format
        //System.out.printf("Hello, %s. Next year, you'll be %d", name, age); format with multiple args and multiple formats
        System.out.printf("You have wagered %8.2F", playerBet); // need to doublecheck formatting on this, maybe just use "You have wagered $" + playerBet + ".00."
    }

    public int askRollDice() {
        int rollValue;
        System.out.println("Are you ready to roll?");
        String playerChoice = myConsole.getStringInput("Enter 1 to roll dice");
        if (playerChoice.equals("1")) {
            rollValue = playerDice.rollPairDice(); // Display dice - make display dice method.
            return rollValue;
        }
        else {
            playerChoice = myConsole.getStringInput("You must enter 1 to roll the dice. You may enter 0 to exit the game and return to the game menu."); // figure this one out
            // need loop here? to return to beginning of method?

        }return 0;
    }

    public void displayDice() {
        getDie1Image();
        getDie2Image();

    }
    public void getDie1Image() {} // ASCI art of the two dice

    public void getDie2Image() {} // ASCI art of the two dice

    public boolean getOddEven () {
        if (rollValue % 2 != 0) {
            return true;          // true if roll odd
        } else {
            return false;         // false if roll even
        }
    }

//    public String getStringInput(String prompt, Object... args) {
//        println(prompt, args);
//        return input.nextLine();

        /*
        greet player

        do you bet on even or odd?

        .greet() {
            System.out.println("Welcome to Cho Han!");
        }
        .askEvenOrOdd(String playerChoice) {
            String playerChoice = "";
            playerChoice = myConsole.getStringInput("1 - 'Hit', 2 - 'Stay'");
            System.out.println("Place your bet; even or odd?");
            System.out.println("Select 1 for odd");
            System.out.println("Select 2 for even");
        }
        .askBetAmount(Double playerBet) {
            Double this.playerBet = playerBet;
            System.out.println("How much would you like to bet?");
        }
        .setBetAmount() {
            save user input
        }
        .askPlayerToRoll() {
            System.out.println("Press 1 when ready to roll the dice!");
        }
        .rollPairDice() {
            return total;
        }
        .asciDice() {
            int valDie1 = .getDie1;
            int valDie2 = .getDie2;
            System.out.println("asci");
        }
        .getWinner() {
        }
        .askPlayAgain() {
        }



        */



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

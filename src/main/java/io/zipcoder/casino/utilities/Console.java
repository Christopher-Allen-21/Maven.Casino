package io.zipcoder.casino.utilities;


import io.zipcoder.casino.Card;
import io.zipcoder.casino.Player.Player;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * You are advised against modifying this class.
 */
public final class Console {
    private final Scanner input;
    private final PrintStream output;
    boolean redo = true;

    public Console(InputStream in, PrintStream out) {
        this.input = new Scanner(in);
        this.output = out;
    }

    public void print(String val, Object... args) {
        output.format(val, args);
    }

    public void println(String val, Object... vals) {
        print(val + "\n", vals);
    }

    public String getStringInput(String prompt, Object... args) {
        println(prompt, args);
        return input.nextLine();
    }

    public Double getDoubleInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            Double doubleInput = Double.parseDouble(stringInput);
            return doubleInput;
        } catch (NumberFormatException nfe) { // TODO - Eliminate recursive nature
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting a numeric value!");
            return getDoubleInput(prompt, args);
        }
    }

    public Long getLongInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            Long longInput = Long.parseLong(stringInput);
            return longInput;
        } catch (NumberFormatException nfe) { // TODO - Eliminate recursive nature
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting an integer value!");
            return getLongInput(prompt, args);
        }
    }

    public Integer getIntegerInput(String prompt, Object... args) {
        return getLongInput(prompt, args).intValue();
    }

    public Integer getCardInput(String prompt) {

        while(true) {
            println(prompt);
            String userInput = input.nextLine();
            if(userInput.equals("2")){
                return 2;
            }
            else if(userInput.equals("3")){
                return 3;
            }
            else if(userInput.equals("4")){
                return 4;
            }
            else if(userInput.equals("5")){
                return 5;
            }
            else if(userInput.equals("6")){
                return 6;
            }
            else if(userInput.equals("7")){
                return 7;
            }
            else if(userInput.equals("8")){
                return 8;
            }
            else if(userInput.equals("9")){
                return 9;
            }
            else if(userInput.equals("10")){
                return 10;
            }
            else if(userInput.equalsIgnoreCase("jack")){
                return 11;
            }
            else if(userInput.equalsIgnoreCase("queen")){
                return 12;
            }
            else if(userInput.equalsIgnoreCase("king")){
                return 13;
            }
            else if(userInput.equalsIgnoreCase("ace")){
                return 14;
            }
        }
    }

    public void displayHandAndBooks(int index, String playerName, ArrayList<Card> hand, Integer playerNumBooks, Integer aiNumBooks,Integer bookTotal){
        System.out.println("Book Total: "+bookTotal);
        System.out.println("Deck Index: "+index);
        System.out.println("AI Number of Books: "+aiNumBooks+"\n");
        System.out.println("Player: "+playerName);
        System.out.println("Number of Books: "+playerNumBooks);
        System.out.println("Current Hand:");
        for(int i=0;i<hand.size();i++){
            System.out.println(" "+hand.get(i));
        }
        System.out.print("\n");
    }

    public Boolean displayPlayAgain(String gameName){
        boolean playAgain;
        while(true) {
            System.out.println("Would you like to play " + gameName + " again?");
            String userInput = input.nextLine();
            if(userInput.equalsIgnoreCase("yes")){
                playAgain = true;
                break;
            }
            else if(userInput.equalsIgnoreCase("no")){
                playAgain = false;
                break;
            }
        }
        return playAgain;
    }

    public String askHitOrStay () {
        String playerChoice = "";
        redo = true;
        while (redo) {
            System.out.println("1 - 'Hit', 2 - 'Stay'");
            playerChoice = input.nextLine();
            switch (playerChoice) {
                case "1":
                    redo = false;
                    return "hit";
                case "2":
                    redo = false;
                    return "stay";
                default:
                    System.out.println("Please choose from the menu!");
            }
        }
       return null;
    }

    public void checkPlayerHand (String playerName, ArrayList<Card> playerHand, Integer total){
        System.out.println(playerName);
        System.out.println("Current hand: ");
        for(int i = 0; i < playerHand.size(); i++ ){
            System.out.println(playerHand.get(i));
        }
        System.out.println("Current total: " + total + "\n");
    }


    public int stageOneBettingPrompt(int stageOfGame){
        System.out.println("Stage of Game: "+stageOfGame);
        while(true) {
            println("Please enter a number to select a bet:");
            println("1. Pass Line bet");
            println("2. Don't Pass Line bet");
            println("3. Non-Field bet");
            String userInput = input.nextLine();
            if(userInput.equals("1")){
                return 1;
            }
            else if(userInput.equals("2")){
                return 2;
            }
            else if(userInput.equals("3")){
                return 3;
            }
        }
    }

    public int stageTwoBettingPrompt(int stageOfGame) {
        System.out.println("Stage of Game: " + stageOfGame);
        while (true) {
            println("Please enter a number to select a bet:");
            println("1. Come Line bet");
            println("2. Don't Come Line bet");
            println("3. Field bet");
            println("4. Non-Field bet");
            println("5. Place bet");
            String userInput = input.nextLine();
            if (userInput.equals("1")) {
                return 1;
            } else if (userInput.equals("2")) {
                return 2;
            } else if (userInput.equals("3")) {
                return 3;
            } else if (userInput.equals("4")) {
                return 4;
            } else if (userInput.equals("5")) {
                return 5;
            }
        }
    }


}


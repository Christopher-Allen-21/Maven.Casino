package io.zipcoder.casino.GameInterface.DiceGame;
import io.zipcoder.casino.Dice;
import io.zipcoder.casino.GameInterface.GamblingGameInterface;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.HashMap;

public class CrapsGame extends DiceGame implements GamblingGameInterface {

    // User makes a bet
    //      User bets on pass line or don't pass line
    //      User makes non-field bet (betting first roll will be 6 or 8 [9 to 1 payout], 4 or 10 [7 to 1 payout], 2 or 12 [30 to 1 payout], 3 or 11 [15 to 1 payout], craps?
    //      First roll of game (come out roll)
    //          if(dice roll = 7 or 11)
    //              betting on pass -> user wins
    //              betting on don't pass -> user loses
    //          else if(dice roll = 2,3,12)
    //              betting on pass -> user loses
    //              betting on don't pass -> user wins
    //          else (4,5,6,8,9,10)
    //              point = dice roll
    //              go to second part of game
    //
    ///
    //  SECOND PART OF game
    //     User makes bet
    //
    //           keep rolling
    //              Bet on come line
    //                  betting they get point again before 7
    //              bet on don' come line
    //                  betting the point doens't come before 7
    //
    //          Field bet (1 roll bet; can only happen in second part of game) -> on next roll, user BETTIGN THEY'LL GET 2,3,4,9,10,11,12 (1 to 1 if 3 through 11) (pays out 2-1 if 2 or 12)
    //          Non-field bets (1 roll bet; can happen at any time) -> betting they'll get one number that they chose
    //
    //          place bets (not a 1 roll bet; can only happen in second part of game) -> don't think they're going to roll point before 7 (picking one of these 4,5,6,8,9,10 that must come before point)

    /*
      makeBets()
            passLine
            dontPassLine
            nonFieldBet
            makeAnotherBet()?
     while(not 4,5,6,8,9,10)
        reset()
        rollDice()
        compareBetsToDiceRoll()
        payOutOrTakeMoney()
      while(secondRoll != 7)
        makeBets()
            comeLine
            dontComeLine
            fieldBet
            nonFieldBet
            placeBet
            makeAnotherBet()?
        rollDice()
        compareBetsToDiceRoll()
        payOutOrTakeMoney()
     */

    int point;
    int stageOfGame = 1;
    Dice dice = new Dice();
    int currentDiceRoll = 0;
    HashMap<String,Double> currentBets = new HashMap<>();
    Console myConsole = new Console(System.in,System.out);
    Player player;

    public CrapsGame(Player player){
        this.player = player;
    }

    public void startGame(){

        while(true){
            resetGame();
            //stage 1
            while(true){
                makeBet();
                currentDiceRoll = dice.rollPairDice();
                compareBetsToDiceRoll(currentDiceRoll);
                if(diceRollEqual4_5_6_8_9_10(currentDiceRoll)){
                    break;
                }
            }

            //stage2
            while(true){
                makeBet();
                currentDiceRoll = dice.rollPairDice();
                compareBetsToDiceRoll(currentDiceRoll);
                if(currentDiceRoll==point){
                    break;
                }
            }


            if(!myConsole.displayPlayAgain("Craps")){
                break;
            }
        }


    }


    public void resetGame(){
        stageOfGame = 1;
        currentBets.clear();
    }

    public void makeBet(){
        do{
            String betChoice;
            double betAmount = 0;
            if(stageOfGame==1){
                betChoice = myConsole.stageOneBettingPrompt(stageOfGame,player);
                //bet amount doesn't check whether they have enough money in balance currently
                betAmount = myConsole.getDoubleInput("How much would you like to bet? Enter dollar amount.");
                currentBets.put(betChoice,betAmount);
            }
            else if(stageOfGame==2){
                betChoice = myConsole.stageTwoBettingPrompt(stageOfGame,player,point);
                //bet amount doesn't check whether they have enough money in balance currently
                betAmount = myConsole.getDoubleInput("How much would you like to bet? Enter dollar amount.");
                currentBets.put(betChoice,betAmount);
            }
        } while(myConsole.makeAnotherBet());
    }

    public void compareBetsToDiceRoll(int diceRoll){
        myConsole.println("You have rolled a " + diceRoll + "!");
        if(stageOfGame==1){
            if(diceRoll==7 || diceRoll==11){
                passLineBet7Or11();
            }
            else if(diceRoll==2 || diceRoll==3 || diceRoll==12){
                passLineBet2_3_12();
            }
            else{
                stageOfGame = 2;
                point = diceRoll;
                myConsole.println(point+" is now the Point");
            }
        }
        else if(stageOfGame==2){
            if(diceRoll==7){
                comeLineBet_7();
            }
            else if(diceRoll==point){
                comeLineBet_point();
            }
            else if(diceRoll!=7 || diceRoll!=point){
                myConsole.println("No winner! Rolling again!");
            }
        }
    }

    public void passLineBet7Or11(){
        if(currentBets.containsKey("passLineBet")){
            double amountBet = currentBets.get("passLineBet");
            player.setPlayerBalance(player.getPlayerBalance()+amountBet);
            myConsole.println("You won!\nPlayer Balance: $"+player.getPlayerBalance());
        }
        else if(currentBets.containsKey("dontPassLineBet")){
            double amountBet = currentBets.get("passLineBet");
            player.setPlayerBalance(player.getPlayerBalance()-amountBet);
            myConsole.println("You lost!\nPlayer Balance: $"+player.getPlayerBalance());
        }
    }

    public void passLineBet2_3_12(){
        if(currentBets.containsKey("passLineBet")){
            double amountBet = currentBets.get("passLineBet");
            player.setPlayerBalance(player.getPlayerBalance()-amountBet);
            myConsole.println("You lost!\nPlayer Balance: $"+player.getPlayerBalance());
        }
        else if(currentBets.containsKey("dontPassLineBet")){
            double amountBet = currentBets.get("passLineBet");
            player.setPlayerBalance(player.getPlayerBalance()+amountBet);
            myConsole.println("You won!\nPlayer Balance: $"+player.getPlayerBalance());
        }
    }

    public void comeLineBet_7(){
        if(currentBets.containsKey("comeLineBet")){
            double amountBet = currentBets.get("comeLineBet");
            player.setPlayerBalance(player.getPlayerBalance()-amountBet);
            myConsole.println("You lost!\nPlayer Balance: $"+player.getPlayerBalance());
        }
        else if(currentBets.containsKey("dontComeLineBet")){
            double amountBet = currentBets.get("dontComeLineBet");
            player.setPlayerBalance(player.getPlayerBalance()+amountBet);
            myConsole.println("You won!\nPlayer Balance: $"+player.getPlayerBalance());
        }
    }

    public void comeLineBet_point(){
        if(currentBets.containsKey("comeLineBet")){
            double amountBet = currentBets.get("comeLineBet");
            player.setPlayerBalance(player.getPlayerBalance()+amountBet);
            myConsole.println("You won!\nPlayer Balance: $"+player.getPlayerBalance());
        }
        else if(currentBets.containsKey("dontComeLineBet")){
            double amountBet = currentBets.get("dontComeLineBet");
            player.setPlayerBalance(player.getPlayerBalance()-amountBet);
            myConsole.println("You lost!\nPlayer Balance: $"+player.getPlayerBalance());
        }
    }

    public boolean diceRollEqual4_5_6_8_9_10(int diceRoll){
        if(diceRoll==4 || diceRoll==5 || diceRoll==6 || diceRoll==7 || diceRoll==8 || diceRoll==10){
            return true;
        }
        else{
            return false;
        }
    }


    public void playerLosesBet() {
    }

    public void playerWinsBet(){
    }

    public void playerHasNoMoney(){
    }

    public void checkWinner(){
    }

}

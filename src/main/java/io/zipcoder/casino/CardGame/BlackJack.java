package io.zipcoder.casino.CardGame;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.GameInterface.GamblingGameInterface;
<<<<<<< HEAD
import io.zipcoder.casino.Player.Player;
=======
import io.zipcoder.casino.Player.BlackJackPlayer;
import io.zipcoder.casino.Player.BlackJackPlayerDealer;
>>>>>>> 040d87f8655285168f5f6d77d38902f422b967e2
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;


public class BlackJack<Cards> extends CardGame implements GamblingGameInterface {
    Console myConsole;
<<<<<<< HEAD


    public BlackJack(Player player1) {
=======
    BlackJackPlayer player1;
    BlackJackPlayerDealer dealer1 = new BlackJackPlayerDealer("Nobles",100.0);
    BlackJackPlayerDealer dealer2 = new BlackJackPlayerDealer("Dolio",100.0);
    BlackJackPlayerDealer dealer3 = new BlackJackPlayerDealer("Younger",100.0);

    public BlackJack(BlackJackPlayer player1) {
        super();
        this.player1 = player1;
>>>>>>> 040d87f8655285168f5f6d77d38902f422b967e2
        myConsole = new Console(System.in, System.out);
    }


    public void startGame() {
        while(true) {

            setStartingPlayerHand();
            setStartingDealerHand();
            askHitOrStay();
            //getTotals();
            compareTotals();
            checkWinner();
        }
    }



    private ArrayList<Card> playerHand = new ArrayList<Card>(0);
    private ArrayList<Card> dealerHand = new ArrayList<Card>(0);
    public void setStartingPlayerHand (){
        do {
            //playerHand.add();
        } while (playerHand.size() != 2);
    }

    public void setStartingDealerHand (){
        do {
            //dealerHand.add();
        } while (playerHand.size() != 2);
    }


    public ArrayList<Card> setPlayerHand (Card card){

        if (askHitOrStay() == "hit") {
            playerHand.add(card);
        }
        else if(askHitOrStay() == "stay") {
            return playerHand;
        }
        return null;
    }

    public String askHitOrStay () {
        String playerChoice = "";
        boolean redo = true;
        while (redo) {
            playerChoice = myConsole.getStringInput("1 - 'Hit', 2 - 'Stay'");
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
    public void aceCheck(Card card){
        if(playerHand.contains(card.getBlackJackValue() == 11));

<<<<<<< HEAD
    //public void askHitOrStay(){}
    //public void compareTotals(){}
=======
>>>>>>> 040d87f8655285168f5f6d77d38902f422b967e2


    }


    public void compareTotals () {
    }

    public void playerLosesBet () {
    }
    public void playerWinsBet () {
    }
    public void playerHasNoMoney () {
    }
    public void checkWinner () {
    }
}


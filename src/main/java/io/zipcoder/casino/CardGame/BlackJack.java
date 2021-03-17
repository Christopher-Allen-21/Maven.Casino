package io.zipcoder.casino.CardGame;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.GameInterface.GamblingGameInterface;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Collections;


public class BlackJack extends CardGame implements GamblingGameInterface {
    Console myConsole;
    int deckIndex = 0;
    Player player1;
    Player dealer1 = new Player("Nobles");
    Player dealer2 = new Player("Dolio");
    Player dealer3 = new Player("Younger");

    public BlackJack(Player player1) {
        super();
        this.player1 = player1;
    }


    public void startGame() {
        while(true) {
            Collections.shuffle(deck);
            dealCards();
            checkPlayerHand();
            //setStartingDealerHand();
            askHitOrStay();
            //getTotals();
            compareTotals();
            checkWinner();
        }
    }



    private ArrayList<Card> playerHand = new ArrayList<Card>(0);
    private ArrayList<Card> dealerHand = new ArrayList<Card>(0);
    public void checkPlayerHand (){
        for(int i = 0; i < playerHand.size(); i++ ){
            System.out.println(playerHand.indexOf(i));
        }
        System.out.println(player1.getHandTotal());
    }

//    public void checkDealerHand (){
//        do {
//            //dealerHand.add();
//        } while (playerHand.size() != 2);
//    }


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
        if(player1.getHandTotal() > 22){
            player1.incrementHandTotal(-10);
        }
    }


    public void compareTotals () {
        Integer total = 0;
        for(int i = 0; i < playerHand.size(); i++){
            total += playerHand.get(i).getValue();
        }
        player1.incrementHandTotal(total);
    }

    public void playerLosesBet () {
    }
    public void playerWinsBet () {
    }
    public void playerHasNoMoney () {
    }


    public void checkWinner () {
        if((player1.getHandTotal() > dealer1.getHandTotal())   && player1.getHandTotal() < 22) {
            System.out.println(player1 + " Wins");
        }
        else if(player1.getHandTotal() < 22 && dealer1.getHandTotal() > 21){
            System.out.println(player1 + " Wins");
        }

        else if((dealer1.getHandTotal() > player1.getHandTotal())   && dealer1.getHandTotal() < 22) {
            System.out.println(dealer1 + " Wins");
        }
        else if(dealer1.getHandTotal() < 22 && player1.getHandTotal() > 21){
            System.out.println(dealer1 + " Wins");
        }
        else if((player1.getHandTotal() == dealer1.getHandTotal()) ||
                (player1.getHandTotal() > 21 && dealer1.getHandTotal() > 21) ){
            System.out.println("Push");
        }
    }

    public void dealCards(){
        for(int i = 0; i < 2; i++){
            player1.getHand().add(deck.get(deckIndex));
            deckIndex++;

        }
        for(int i = 0; i < 2; i++){
            dealer1.getHand().add(deck.get(deckIndex));
            deckIndex++;
        }
    }

}


package io.zipcoder.casino.CardGame;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.GameInterface.GamblingGameInterface;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;
import java.util.Collections;
import java.util.Objects;


public class BlackJack extends CardGame implements GamblingGameInterface {
    private Console console = new Console(System.in,System.out);
    int deckIndex = 0;
    Player player1;
    Player dealer1 = new Player("Nobles");
    Player dealer2 = new Player("Dolio");
    Player dealer3 = new Player("Younger");
    boolean gameOn = true;
    boolean hit = true;

    public BlackJack(Player player1) {
        super();
        this.player1 = player1;
    }


    public void startGame() {
        while(gameOn) {
            resetGame();
            Collections.shuffle(deck);
            dealCards();
            getPlayerTotals();
            console.checkPlayerHand(player1, player1.getHand(), player1.getHandTotal());
            if(player1.getHandTotal() != 21) {
                do {
                    checkIfPlayerHit();
                    if (player1.getHandTotal() > 21) {
                        System.out.println("Bust");
                        break;
                    }
                }while(hit);
            }
            checkWinner();
            hit = true;
            gameOn = console.displayPlayAgain("BlackJack");
        }
    }

    public void resetGame(){
        deckIndex = 0;
        player1.setHandTotal(0);
        player1.getHand().clear();
    }

    public void checkIfPlayerHit (){
        if (Objects.equals(console.askHitOrStay(), "hit")) {
            addCard();
            getPlayerTotals();
            console.checkPlayerHand(player1,player1.getHand(), player1.getHandTotal());
            //hit = true;
        }
        else if(Objects.equals(console.askHitOrStay(), "stay")) {
            hit = false;//Needs to change to method that makes the dealer draw cards until they have 18 or less;
        }

    }



    public void aceCheck(Card card){
        if(player1.getHand().contains(card.getBlackJackValue() == 11)) {
            if (player1.getHandTotal() > 22) {
                player1.incrementHandTotal(-10);
            }
        }
    }


    public void getPlayerTotals () {
        Integer total = 0;
        for(int i = 0; i < player1.getHand().size(); i++){
            total += player1.getHand().get(i).getBlackJackValue();
        }
        player1.setHandTotal(total);
    }

    public void playerLosesBet () {
    }
    public void playerWinsBet () {
    }
    public void playerHasNoMoney () {
    }


    public void checkWinner () {
        if((player1.getHandTotal() > dealer1.getHandTotal())   && player1.getHandTotal() < 22) {
            System.out.println("\nplayer1 Wins");
        }
        else if(player1.getHandTotal() < 22 && dealer1.getHandTotal() > 21){
            System.out.println("\nplayer1 Wins");
        }

        else if((dealer1.getHandTotal() > player1.getHandTotal())   && dealer1.getHandTotal() < 22) {
            System.out.println("\ndealer1 Wins");
        }
        else if(dealer1.getHandTotal() < 22 && player1.getHandTotal() > 21){
            System.out.println("\ndealer1 Wins");
        }
        else if((player1.getHandTotal() == dealer1.getHandTotal()) ||
                (player1.getHandTotal() > 21 && dealer1.getHandTotal() > 21) ){
            System.out.println("\nPush");
        }
        gameOn = false;

    }

    public void dealCards(){

            while(player1.getHand().size() < 2) {
                player1.getHand().add(deck.get(deckIndex));
                deckIndex++;
            }
            while (dealer1.getHand().size() < 2) {
                dealer1.getHand().add(deck.get(deckIndex));
                deckIndex++;
            }

    }

    public void addCard(){
        player1.getHand().add(deck.get(deckIndex));
        deckIndex++;
        if(player1.getHandTotal() > 21){
            checkWinner();
        }
    }
}


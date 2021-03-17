package io.zipcoder.casino.CardGame;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.Collections;


public class GoFishGame extends CardGame {

    private Console myConsole = new Console(System.in,System.out);
    private Player currentPlayer;
    private Player aiPlayer = new Player("Nobles");
    int deckIndex = 0;


    public GoFishGame(Player currentPlayer){
        super();
        this.currentPlayer = currentPlayer;
    }

    public void startGame(){
        while(true){
            deckIndex = 0;
            Collections.shuffle(deck);
            dealCards();
            askForCards();


        }
    }

    @Override
    public void dealCards(){
        for(int i=0;i<9;i++){
            currentPlayer.getPlayerHand().add(deck.get(deckIndex));
            deckIndex++;

        }
        for(int i=0;i<9;i++){
            aiPlayer.getPlayerHand().add(deck.get(deckIndex));
            deckIndex++;
        }
    }

    public void askForCards(){

        String cardPicked = myConsole.getCardInput("Ask opposing player for a card:");


    }

    public void compareNumBooks(){}
    public void passPlayCard(){}

    public void checkWinner() {

    }

    public void resetGame(){

    }
}

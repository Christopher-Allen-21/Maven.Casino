package io.zipcoder.casino.CardGame;
import io.zipcoder.casino.Card;
import io.zipcoder.casino.Player.GoFishPlayer;

import java.util.ArrayList;
import java.util.Collections;


public class GoFishGame extends CardGame {

    private GoFishPlayer currentPlayer;
    private GoFishPlayer aiPlayer;
    int deckIndex = 0;


    public GoFishGame(GoFishPlayer currentPlayer){
        super();
        this.currentPlayer = currentPlayer;
    }

    public void startGame(){
        while(true){
            deckIndex = 0;
            Collections.shuffle(deck);
            dealCards();


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

    public void compareNumBooks(){}
    public void passPlayCard(){}

    public void checkWinner() {

    }

    public void resetGame(){

    }
}

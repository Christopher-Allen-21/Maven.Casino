package io.zipcoder.casino.Player;

import io.zipcoder.casino.Card;

import java.util.ArrayList;

public class GoFishPlayer extends Player{
    Integer numBooks;
    ArrayList<Card> playerHand = new ArrayList<Card>();

    public GoFishPlayer(String playerName){
        super(playerName);
    }

    public void askForCardType(){

    }

    public void drawCard(){

    }

    public void sayGoFish(){

    }

    public Integer getNumBooks(){
        return numBooks;
    }

}

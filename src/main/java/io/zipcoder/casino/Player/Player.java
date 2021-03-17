package io.zipcoder.casino.Player;

import io.zipcoder.casino.Card;

import java.util.ArrayList;

public class Player {
    String playerName;
    Integer numBooks=0;
    Integer handTotal=0;
    ArrayList<Card> playerHand = new ArrayList<Card>();

    public Player(String playerName){
        this.playerName = playerName;
    }




    public String getName(){
        return playerName;
    }
    public void setName(String playerName){
        this.playerName = playerName;
    }

    public ArrayList<Card> getPlayerHand(){
        return playerHand;
    }

    public Integer getNumBooks(){ return numBooks; }
    public void incrementNumBooks(Integer amountToAdd){numBooks+=amountToAdd;}

    public Integer getHandTotal(){ return handTotal; }
    public void incrementHandTotal(Integer amountToAdd){handTotal+=amountToAdd;}






}

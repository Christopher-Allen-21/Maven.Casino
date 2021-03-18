package io.zipcoder.casino.Player;
import io.zipcoder.casino.Card;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Player {
    String playerName;
    Integer numBooks=0;
    Integer handTotal=0;
    ArrayList<Card> hand = new ArrayList<Card>();
    Double playerBalance;

    public Player(String playerName){
        this.playerName = playerName;
    }



    public String getName(){
        return playerName;
    }
    public void setName(String playerName){
        this.playerName = playerName;
    }

    public ArrayList<Card> getHand(){
        return hand;
    }
    public ArrayList<Card> getSortedHand(){
        sortHand();
        return hand;
    }
    public void setHand(ArrayList<Card> hand){this.hand = hand;}
    public void sortHand(){ Collections.sort(hand);}

    public Integer getNumBooks(){ return numBooks; }
    public void incrementNumBooks(Integer amountToAdd){numBooks+=amountToAdd;}

    public Integer getHandTotal(){ return handTotal; }
    public void incrementHandTotal(Integer amountToAdd){handTotal+=amountToAdd;}
    public void setHandTotal(Integer handTotal){this.handTotal = handTotal;}

    public Double getPlayerBalance(){
        return playerBalance;
    }
    public void setPlayerBalance(Double playerBalance){
        this.playerBalance = playerBalance;
    }

    public void placeBet(){ }

    public void cashOut(){ }

    public void collectWinnings(){ }




}

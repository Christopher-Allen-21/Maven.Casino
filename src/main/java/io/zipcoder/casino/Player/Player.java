package io.zipcoder.casino.Player;

public class Player {
    String playerName;

    public Player(String playerName){
        this.playerName = playerName;
    }

    public String getName(){
        return playerName;
    }

    public void setName(String playerName){
        this.playerName = playerName;
    }
}

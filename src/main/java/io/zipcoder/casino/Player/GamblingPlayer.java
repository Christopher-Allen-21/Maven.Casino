package io.zipcoder.casino.Player;

public class GamblingPlayer extends Player{
    Double playerBalance;

    public GamblingPlayer(String playerName, Double playerBalance){
        super(playerName);
        this.playerBalance = playerBalance;
    }

    public Double getPlayerBalance(){
        return playerBalance;
    }

    public void setPlayerBalance(Double playerBalance){
        this.playerBalance = playerBalance;
    }

    public void placeBet(double playerWagerAmt){
        this.playerBalance -= playerWagerAmt;
    }

    public void cashOut(){

    }

    public void collectWinnings(){

    }




}

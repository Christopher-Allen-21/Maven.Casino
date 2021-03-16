package io.zipcoder.casino.CardGame;

import io.zipcoder.casino.GameInterface.GamblingGameInterface;

public class BlackJack extends CardGame implements GamblingGameInterface {
    //ArrayList<Cards> currentHand = new ArrayList<Cards>();

    public BlackJack(){}

    @Override
    public void dealCards() {

    }

    public void askHitOrStay(){}
    public void compareTotals(){}

    public void playerLosesBet() {}
    public void playerWinsBet(){}
    public void playerHasNoMoney(){}
    public void checkWinner(){}
}

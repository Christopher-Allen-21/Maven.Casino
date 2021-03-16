package io.zipcoder.casino.GameInterface;

public interface GamblingGameInterface extends GameInterface {
    public void playerLosesBet();
    public void playerWinsBet();
    public void playerHasNoMoney();
    public void checkWinner ();
}

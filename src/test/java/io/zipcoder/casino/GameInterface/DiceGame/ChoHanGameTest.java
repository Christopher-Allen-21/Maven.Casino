package io.zipcoder.casino.GameInterface.DiceGame;

import io.zipcoder.casino.CardGame.BlackJack;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChoHanGameTest {
    Player p1 = new Player("Kells", 100.0);
    ChoHanGame testGame = new ChoHanGame(p1);
    Console testConsole = new Console(System.in, System.out);

    @Test
    public void askEvenOdd() { //asks for input, string even or odd, if yes, playerchoice gets set to even or odd
        // Arrange
        testGame.askEvenOdd();

        // Act

        // Assert

    }

    @Test
    public void askWager() {
        // Arrange

        // Act

        // Assert

    }

    @Test
    public void askRollDice() {
        // Arrange

        // Act

        // Assert

    }

    @Test
    public void ifOdd() {
        // Arrange

        // Act

        // Assert

    }

    @Test
    public void checkWinner() {
        // Arrange

        // Act

        // Assert

    }

    @Test
    public void playerWinsBet() {
        // Arrange

        // Act

        // Assert

    }

    @Test
    public void displayPlayerBalance() {
        // Arrange

        // Act

        // Assert

    }

}
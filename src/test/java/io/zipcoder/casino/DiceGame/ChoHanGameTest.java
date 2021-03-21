package io.zipcoder.casino.DiceGame;

import io.zipcoder.casino.CardGame.BlackJack;
import io.zipcoder.casino.GameInterface.DiceGame.ChoHanGame;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChoHanGameTest {
    Player p1 = new Player("Kells", 100.0);
    ChoHanGame testGame = new ChoHanGame(p1);
    Console testConsole = new Console(System.in, System.out);



    @Test
    public void askRollDice() {
        // Arrange

        // Act

        // Assert

    }

//    @Test
//    public void ifOdd() {
//        // Arrange
//        Player p1 = new Player("Kells", 100.0);
//        ChoHanGame testGame = new ChoHanGame(p1);
//        // Act
//        String returned = testConsole.playerChoice;
//        // Assert
//
//    }

    @Test
    public void checkWinner() {
        // Arrange

        // Act

        // Assert

    }



}
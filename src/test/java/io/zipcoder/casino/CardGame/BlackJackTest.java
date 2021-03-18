package io.zipcoder.casino.CardGame;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.Player.Player;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.InputStream;

public class BlackJackTest {
    Player p1 = new Player("Jorge");
    BlackJack newGame = new BlackJack(p1);
    Console console;

//    @Test
//    public void setPlayerHandTest(){
//        // Arrange
//        InputStream sysInBackup = System.in; // backup System.in to restore it later
//        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
//        System.setIn(in);
//
//        // Expected
//        int expected = p1.getHand().size() + 1;
//
//        // Action
//        newGame.setPlayerHand();
//        int actual = p1.getHand().size();
//        // Assert
//        Assert.assertEquals(expected, actual);
//
//    }
}

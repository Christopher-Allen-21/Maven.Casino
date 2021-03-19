package io.zipcoder.casino.CardGame;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.Player.Player;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GoFishGameTest extends TestCase {


    public void testResetGame() {
        //Arrange
        Player player = new Player("Chris", 100.0);
        GoFishGame game = new GoFishGame(player);
        Card card1 = new Card("Spades",2);
        Card card2 = new Card("Clubs",2);
        player.getHand().add(card1);
        player.getHand().add(card2);

        //Act
        game.resetGame();
        ArrayList<Card> expected = new ArrayList<>();
        ArrayList<Card> actual = player.getHand();

        //Assert
        Assert.assertEquals(expected,actual);


    }

    public void testCheckHandForBooks(){
        //Arrange
        Player player = new Player("Chris", 100.0);
        GoFishGame game = new GoFishGame(player);
        Card card1 = new Card("Spades",2);
        Card card2 = new Card("Clubs",2);
        Card card3 = new Card("Hearts",2);
        Card card4 = new Card("Diamonds",2);
        player.getHand().add(card1);
        player.getHand().add(card2);
        player.getHand().add(card3);
        player.getHand().add(card4);

        //Act
        boolean expected = true;
        boolean actual = game.checkHandForBooks(player);


        //Assert
        Assert.assertEquals(expected, actual);
    }

    public void testCheckHandForBooks2(){
        //Arrange
        Player player = new Player("Chris", 100.0);
        GoFishGame game = new GoFishGame(player);
        Card card1 = new Card("Spades",3);
        Card card2 = new Card("Clubs",3);
        Card card3 = new Card("Hearts",13);
        Card card4 = new Card("Diamonds",3);
        player.getHand().add(card1);
        player.getHand().add(card2);
        player.getHand().add(card3);
        player.getHand().add(card4);

        //Act
        boolean expected = false;
        boolean actual = game.checkHandForBooks(player);


        //Assert
        Assert.assertEquals(expected, actual);
    }
}
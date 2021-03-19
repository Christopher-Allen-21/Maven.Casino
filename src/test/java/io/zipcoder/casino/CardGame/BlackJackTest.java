package io.zipcoder.casino.CardGame;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.Player.Player;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.InputStream;

public class BlackJackTest {
    Player p1 = new Player("Jorge", 100.0);
    BlackJack newGame = new BlackJack(p1);
    Console console;

    @Test
    public void resetHandTotalTest(){
        //Arrange
        Card card1 = new Card("Spades",2);
        p1.getHand().add(card1);

        //Action
        newGame.resetGame();
        int expected = 0;
        int actual = p1.getHandTotal();

        //Assert
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void resetHandTest(){
        //Arrange
        Card card1 = new Card("Spades",2);
        p1.getHand().add(card1);

        //Action
        newGame.resetGame();
        int expected = 0;
        int actual = p1.getHand().size();

        //Assert
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void resetDeckIndexTest(){
        //Arrange
        newGame.deckIndex = 10;

        //Action
        newGame.resetGame();
        int expected = 0;
        int actual = newGame.deckIndex;

        //Assert
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addCardTestThree(){
            //Arrange
            Card card1 = new Card("Spades",2);
            Card card2 = new Card("Clubs",2);
            Card card3 = new Card("Hearts",2);

            //Act
            p1.getHand().add(card1);
            p1.getHand().add(card2);
            p1.getHand().add(card3);
            int expected = 3;
            int actual = p1.getHand().size();


            //Assert
            Assert.assertEquals(expected, actual);
        }
    @Test
    public void addCardTestFour(){
        //Arrange
        Card card1 = new Card("Spades",2);
        Card card2 = new Card("Clubs",2);
        Card card3 = new Card("Hearts",2);
        Card card4 = new Card("Hearts",2);

        //Act
        p1.getHand().add(card1);
        p1.getHand().add(card2);
        p1.getHand().add(card3);
        p1.getHand().add(card4);
        int expected = 4;
        int actual = p1.getHand().size();


        //Assert
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void playerBetTest20(){
        //Arrange
        p1.setPlayerBalance(100.0);


        //Action
        p1.placeBet(20.0);
        double expected = 80.0;
        double actual = p1.getPlayerBalance();

        //Assert
        Assert.assertEquals(expected,actual,0.01);
    }
    @Test
    public void playerBetTest100(){
        //Arrange
        p1.setPlayerBalance(100.0);


        //Action
        p1.placeBet(100.0);
        double expected = 0.0;
        double actual = p1.getPlayerBalance();

        //Assert
        Assert.assertEquals(expected,actual,0.01);
    }
    @Test
    public void playerWinsBetTest50(){
        //Arrange
        p1.setPlayerBalance(100.0);
        p1.placeBet(50.0);

        //Action
        p1.collectWinnings(50.0);
        double expected = 150.0;
        double actual = p1.getPlayerBalance();

        //Assert
        Assert.assertEquals(expected,actual,0.01);
    }
    @Test
    public void playerWinsBetTest100(){
        //Arrange
        p1.setPlayerBalance(100.0);
        p1.placeBet(100.0);

        //Action
        p1.collectWinnings(100.0);
        double expected = 200.0;
        double actual = p1.getPlayerBalance();

        //Assert
        Assert.assertEquals(expected,actual,0.01);
    }
    @Test
    public void dealCardsTest(){
        //Arrange
        p1.getHand().clear();

        //Action
        newGame.dealCards(p1);
        int expected = 2;
        int actual = p1.getHand().size();

        //Assert
        Assert.assertEquals(expected,actual);
    }
}

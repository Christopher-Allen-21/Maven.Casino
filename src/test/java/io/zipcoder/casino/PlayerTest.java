package io.zipcoder.casino;

import io.zipcoder.casino.Player.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertArrayEquals;

public class PlayerTest {


    private Object ArrayList;

    @Test
    public void getNameTest(){
        //Arrange
        Player player = new Player("Name",1000.0);

        //Action
        String expected = "Name";
        String actual = player.getName();

        //Assertion
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getPlayerBalanceTest(){
        //Arrange
        Player player = new Player("Name",1000.0);

        //Action
        double expected = 1000.0;
        double actual = player.getPlayerBalance();

        //Assertion
        Assert.assertEquals(expected,actual,0.01);
    }
    @Test
    public void setPlayerBalanceTest(){
        //Arrange
        Player player = new Player("Name",0.0);

        //Action
        player.setPlayerBalance(1000.0);
        double expected = 1000.0;
        double actual = player.getPlayerBalance();

        //Assertion
        Assert.assertEquals(expected,actual,0.01);
    }
    @Test
    public void setPlayerBetTest() {
        //Arrange
        Player player = new Player("Name", 0.0);

        //Action
        player.setPlayerBalance(1000.0);
        double expected = 1000.0;
        double actual = player.getPlayerBalance();

        //Assertion
        Assert.assertEquals(expected, actual, 0.01);
    }
    @Test
    public void getHandTest(){
        //Arrange
        Player player = new Player("Name", 0.0);
        ArrayList<Card> expected = new ArrayList<Card>();
        Card card1 = new Card("Spades",2);
        Card card2 = new Card("Clubs",2);
        Card card3 = new Card("Hearts",2);
        Card card4 = new Card("Diamonds",2);
        player.getHand().add(card1);
        player.getHand().add(card2);
        player.getHand().add(card3);
        player.getHand().add(card4);

        //Action
        expected.add(card1);
        expected.add(card2);
        expected.add(card3);
        expected.add(card4);
        ArrayList<Card> actual = player.getHand();

        //Assert
        assertArrayEquals(expected.toArray(),actual.toArray());
    }
    @Test
    public void getSortedHandTest(){
        //Arrange
        Player player = new Player("Name", 0.0);
        ArrayList<Card> expected = new ArrayList<Card>();
        Card card1 = new Card("Spades",2);
        Card card2 = new Card("Clubs",2);
        Card card3 = new Card("Hearts",2);
        Card card4 = new Card("Diamonds",2);
        player.getHand().add(card1);
        player.getHand().add(card2);
        player.getHand().add(card3);
        player.getHand().add(card4);

        //Action
        expected.add(card1);
        expected.add(card2);
        expected.add(card3);
        expected.add(card4);
        Collections.sort(expected);
        ArrayList<Card> actual = player.getSortedHand();

        //Assert
        assertArrayEquals(expected.toArray(),actual.toArray());
    }
    @Test
    public void collectWinningsTest() {
        //Arrange
        Player player = new Player("Name", 100.0);
        player.placeBet(100.0);

        //Action
        player.collectWinnings(100.0);
        double expected = 200.0;
        double actual = player.getPlayerBalance();

        //Assertion
        Assert.assertEquals(expected,actual,0.01);
    }
}

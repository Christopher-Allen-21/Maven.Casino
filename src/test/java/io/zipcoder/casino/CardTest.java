package io.zipcoder.casino;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;
import org.junit.Assert;
import sun.jvm.hotspot.utilities.AssertionFailure;

public class CardTest extends TestCase {

    public void testIsHigherThan1() {
        //Arrange
        Card card1 = new Card("hearts",5);
        Card card2 = new Card("hearts",2);

        //Act
        boolean expected = true;
        boolean actual = card1.isHigherThan(card2);

        //Assert
        Assert.assertEquals(expected, actual);
    }

    public void testIsHigherThan2() {
        //Arrange
        Card card1 = new Card("Diamonds",2);
        Card card2 = new Card("Hearts",11);

        //Act
        boolean expected = false;
        boolean actual = card1.isHigherThan(card2);

        //Assert
        Assert.assertEquals(expected, actual);
    }

    public void testAssignColorDiamonds() {
        //Arrange
        Card card1 = new Card("Diamonds",2);

        //Act
        String expected1 = "red";
        String actual1 = card1.assignColor();

        //Assert
        Assert.assertEquals(expected1, actual1);

    }
    public void testAssignColorHearts() {
        //Arrange
        Card card = new Card("Hearts",2);

        //Act
        String expected = "red";
        String actual = card.assignColor();

        //Assert
        Assert.assertEquals(expected, actual);
    }

    public void testAssignColorSpades() {
        //Arrange
        Card card = new Card("Spades",2);

        //Act
        String expected = "black";
        String actual = card.assignColor();

        //Assert
        Assert.assertEquals(expected, actual);
    }

    public void testAssignColorClubs() {
        //Arrange
        Card card = new Card("Clubs",2);

        //Act
        String expected = "black";
        String actual = card.assignColor();

        //Assert
        Assert.assertEquals(expected, actual);
    }


    public void testCreateFaceCardJack() {
        //Arrange
        Card card = new Card("Clubs",11);

        //Act
        String expected = "Jack";
        String actual = card.createFaceCard();

        //Assert
        Assert.assertEquals(expected, actual);
    }

    public void testIsFaceCardJack() {
        //Arrange
        Card card = new Card("Clubs",11); //Jack

        //Act
        boolean expected = true;
        boolean actual = card.isFaceCard();

        //Assert
        Assert.assertEquals(expected, actual);
    }
    public void testIsFaceCardQueen() {
        //Arrange
        Card card = new Card("Hearts",12); //Queen

        //Act
        boolean expected = true;
        boolean actual = card.isFaceCard();

        //Assert
        Assert.assertEquals(expected, actual);
    }
    public void testIsFaceCardKing() {
        //Arrange
        Card card = new Card("Diamonds",13); //King

        //Act
        boolean expected = true;
        boolean actual = card.isFaceCard();

        //Assert
        Assert.assertEquals(expected, actual);
    }

    public void testIsFaceCardAce() {
        //Arrange
        Card card = new Card("Diamonds",14); //Ace

        //Act
        boolean expected = true;
        boolean actual = card.isFaceCard();

        //Assert
        Assert.assertEquals(expected, actual);
    }
    public void testIsFaceCard8() {
        //Arrange
        Card card = new Card("Diamonds",8); //Ace

        //Act
        boolean expected = false;
        boolean actual = card.isFaceCard();

        //Assert
        Assert.assertEquals(expected, actual);
    }
    public void testIsFaceCard2() {
        //Arrange
        Card card = new Card("Diamonds",2); //Ace

        //Act
        boolean expected = false;
        boolean actual = card.isFaceCard();

        //Assert
        Assert.assertEquals(expected, actual);
    }

    public void testGetBlackJackValue() {
    }

    public void testTestToString() {
    }

    public void testGetSuit() {
    }

    public void testGetColorDiamonds() {
        //Arrange
        Card card1 = new Card("Diamonds",2);

        //Act
        String expected1 = "red";
        String actual1 = card1.getColor();

        //Assert
        Assert.assertEquals(expected1, actual1);

    }
    public void testGetColorHearts() {
        //Arrange
        Card card1 = new Card("Hearts",2);

        //Act
        String expected1 = "red";
        String actual1 = card1.getColor();

        //Assert
        Assert.assertEquals(expected1, actual1);
    }

    public void testGetColorSpades() {
        //Arrange
        Card card1 = new Card("Spades",2);

        //Act
        String expected1 = "black";
        String actual1 = card1.getColor();

        //Assert
        Assert.assertEquals(expected1, actual1);
    }

    public void testGetColorClubs() {
        //Arrange
        Card card1 = new Card("Clubs",2);

        //Act
        String expected1 = "black";
        String actual1 = card1.getColor();

        //Assert
        Assert.assertEquals(expected1, actual1);
    }

    public void testGetValue() {
    }
}
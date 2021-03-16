package io.zipcoder.casino;

import junit.framework.TestCase;
import org.junit.Assert;

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

    public void testAssignColor1() {
        //Arrange
        Card card1 = new Card("Diamonds",2);

        //Act
        String expected1 = "red";
        String actual1 = card1.assignColor();

        //Assert
        Assert.assertEquals(expected1, actual1);

    }
    public void testAssignColor2() {
        //Arrange
        Card card1 = new Card("Hearts",2);

        //Act
        String expected1 = "red";
        String actual1 = card1.assignColor();

        //Assert
        Assert.assertEquals(expected1, actual1);
    }

    public void testAssignColor3() {
        //Arrange
        Card card1 = new Card("Spades",2);

        //Act
        String expected1 = "black";
        String actual1 = card1.assignColor();

        //Assert
        Assert.assertEquals(expected1, actual1);
    }

    public void testAssignColor4() {
        //Arrange
        Card card1 = new Card("Clubs",2);

        //Act
        String expected1 = "black";
        String actual1 = card1.assignColor();

        //Assert
        Assert.assertEquals(expected1, actual1);
    }


    public void testCreateFaceCard() {
    }

    public void testIsFaceCard() {
    }

    public void testGetBlackJackValue() {
    }

    public void testTestToString() {
    }

    public void testGetSuit() {
    }

    public void testGetColor() {
    }

    public void testGetValue() {
    }
}
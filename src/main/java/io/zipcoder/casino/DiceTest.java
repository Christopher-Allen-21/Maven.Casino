package io.zipcoder.casino;


import org.testng.Assert;
import org.testng.annotations.Test;

public class DiceTest {

    @Test
    public void constructorTest1() {
        // Arrange

        // Act
        Dice testDicePair = new Dice();
        int diceTotal = testDicePair.getDiceTotal();

        // Assert
        Assert.assertNotEquals(1, diceTotal);

    }

    @Test
    public void constructorTest2() {
        // Arrange

        // Act
        Dice testDicePair = new Dice();
        int diceTotal = testDicePair.getDiceTotal();

        // Assert
        Assert.assertNotEquals(1, diceTotal);

    }

}

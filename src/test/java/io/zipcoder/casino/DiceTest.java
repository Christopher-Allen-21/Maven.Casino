package io.zipcoder.casino;


import org.testng.Assert;
import org.testng.annotations.Test;

public class DiceTest {

    @Test
    public void constructorTest1() {
        // Arrange
        Dice testDicePair = new Dice();
        // Act
        int diceTotal = 0;
        for (int i = 0; i < 100; i++) {
            diceTotal = testDicePair.rollPairDice();
        }
        // Assert
        Assert.assertTrue(diceTotal > 2 && diceTotal < 13);
    }

    @Test
    public void constructorTest2() {
        // Arrange
        Dice testDicePair = new Dice();
        // Act
        int diceTotal = 0;
        for (int i = 0; i < 100; i++) {
            diceTotal = testDicePair.rollPairDice();
            System.out.println(testDicePair.rollPairDice());
        }
        // Assert
        Assert.assertTrue(diceTotal > 2 && diceTotal < 13);

    }

}

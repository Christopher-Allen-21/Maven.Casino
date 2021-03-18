package io.zipcoder.casino;


import org.testng.Assert;
import org.testng.annotations.Test;

public class DiceTest {

    @Test
    public void constructorTest1() {
        // Arrange

        // Act
        Dice testDicePair = new Dice();
        int diceTotal = 0;
        for (int i = 0; i < 100; i++) {
            diceTotal = testDicePair.rollPairDice();
            System.out.println(testDicePair.rollPairDice());
        }

        // Assert
        Assert.assertTrue(diceTotal > 2 && diceTotal < 13);

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

package io.zipcoder.casino;


import org.testng.Assert;
import org.testng.annotations.Test;

public class DiceTest {

    @Test
    public void constructorTest1() { // sum of dice never exceeds 12, never less than 2
        // Arrange
        Dice testDicePair = new Dice();
        // Act
        int diceTotal = 0;
        for (int i = 0; i < 1000; i++) {
            diceTotal = testDicePair.rollPairDice();
        }
        // Assert
        Assert.assertTrue(diceTotal > 2 && diceTotal < 13);
    }

    @Test
    public void constructorTest2() { // highest value of sum of dice never exceeds 12
        // Arrange
        Dice testDicePair = new Dice();
        // Act
        int diceTotal = 0;
        int diceMax = 0;
        for (int i = 0; i < 100; i++) {
            diceTotal = testDicePair.rollPairDice();
            if (diceMax <= diceTotal) {
                diceMax = diceTotal;
            }
        }
        // Assert
        Assert.assertTrue(diceMax < 13 );
    }

    @Test
    public void constructorTest3() { // lowest value of sum of dice never less than 2
        // Arrange
        Dice testDicePair = new Dice();
        // Act
        int diceTotal = 0;
        int diceMin = 12;
        for (int i = 0; i < 1000; i++) {
            diceTotal = testDicePair.rollPairDice();
            if (diceTotal <= diceMin) {
                diceMin = diceTotal;
            }
        }
        // Assert
        Assert.assertTrue(diceMin > 1 );
    }


    @Test
    public void rollPairDice() {
        // Arrange
        Dice testDicePair = new Dice();
        // Act
        int diceTotal = 0;
        for (int i = 0; i < 1000; i++) {
            diceTotal = testDicePair.rollPairDice();
        }
        // Assert
        Assert.assertTrue(diceTotal > 2 && diceTotal < 13);
    }

    @Test
    public void getDie1() {
        // Arrange
        Dice testDicePair = new Dice();
        // Act
        int dieTotal = 0;
        int dieMin = 6;
        for (int i = 0; i < 1000; i++) {
            testDicePair.rollPairDice();
            dieTotal = testDicePair.getDie1();
            if (dieTotal <= dieMin) {
                dieMin = dieTotal;
            }
        }
        // Assert
        Assert.assertTrue(dieMin > 0);
    }

    @Test
    public void getDie2() {
        // Arrange
        Dice testDicePair = new Dice();
        // Act
        int dieTotal = 0;
        int dieMax = 0;
        for (int i = 0; i < 1000; i++) {
            testDicePair.rollPairDice();
            dieTotal = testDicePair.getDie2();
            if (dieMax <= dieTotal) {
                dieMax = dieTotal;
            }
        }
        // Assert
        Assert.assertTrue(dieMax < 7);
    }

    @Test
    public void getDiceTotal() {
        // Arrange
        Dice testDicePair = new Dice();
        // Act
        int diceTotal = 0;
        for (int i = 0; i < 1000; i++) {
            testDicePair.rollPairDice();
            diceTotal = testDicePair.getDiceTotal();
        }
        // Assert
        Assert.assertTrue(diceTotal > 2 && diceTotal < 13);
    }
}

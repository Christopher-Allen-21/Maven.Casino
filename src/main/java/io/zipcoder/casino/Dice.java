package io.zipcoder.casino;

public class Dice {

    private int die1;
    private int die2;

    public Dice() {
        rollPairDice();
    }

    public int rollPairDice() {
        die1 = (int) (Math.random() * 6) + 1;
        die2 = (int) (Math.random() * 6) + 1;
        return die1 + die2;

    }

    public int getDie1() {
        return die1;
    }

    public int getDie2() {
        return die2;
    }

    public int getDiceTotal() {
        return die1 + die2;
    }
}

package io.zipcoder.casino;

public class Card {

    String suit;
    int value;

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public boolean isHigher() { return true; }

    public String getSuit() { return suit; }

    public int getValue() { return value; }

}

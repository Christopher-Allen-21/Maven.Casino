package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    public final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    public final int CARDS_IN_DECK = 52;
    public final int CARDS_IN_SUIT = 13;
    ArrayList<Card> deck = new ArrayList<Card>();


    public Deck() {
        generateDeck();

    }

    public void generateDeck(){
        for(int i=0;i<SUITS.length;i++){
            for(int cardValue=2;cardValue<=CARDS_IN_SUIT+1;cardValue++){
                Card newCard = new Card(SUITS[i],cardValue);
                deck.add(newCard);
            }
        }
    }

    public ArrayList<Card> shuffleDeck() {
        Collections.shuffle(deck);
        return deck;
    }

}

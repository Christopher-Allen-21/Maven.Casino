package io.zipcoder.casino.CardGame;
import io.zipcoder.casino.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardGame {
    public final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    public final int CARDS_IN_DECK = 52;
    public final int CARDS_IN_SUIT = 13;
    ArrayList<Card> deck = new ArrayList<Card>();
    ArrayList<Card> currentHand = new ArrayList<Card>();

    public CardGame(){
        generateDeck();
    }

    public void dealCards() {
        int counter = 0;
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

    public ArrayList<Card> getDeck(){
        return deck;
    }

    public void addCard(){

    }

}

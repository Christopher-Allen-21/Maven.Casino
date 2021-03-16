package io.zipcoder.casino;

public class Card {

    String suit;
    String color;
    int value;
    String faceCard;

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
        color = assignColor();
        faceCard = createFaceCard();

    }


    public boolean isHigherThan(Card otherCard) {
        if(this.value>otherCard.value){
            return true;
        }
        else{
            return false;
        }
    }

    public String assignColor() {
        String color;
        if(suit.equals("Hearts") || suit.equals("Diamonds")){
            color = "red";
        }
        else{
            color = "black";
        }
        return color;
    }

    public String createFaceCard(){
        String faceCard;
        if(value == 11){
            faceCard = "Jack";
        }
        else if(value == 12){
            faceCard = "Queen";
        }
        else if(value == 13){
            faceCard = "King";
        }
        else if(value == 14){
            faceCard = "Ace";
        }
        else{
            faceCard = null;
        }
        return faceCard;
    }

    public boolean isFaceCard(){
        if(faceCard == null){
            return false;
        }
        else{
            return true;
        }
    }

    public int getBlackJackValue(){
        int value = 0;
        if(getValue() == 14){ //Ace
            value = 11;
        }
        else if(getValue() > 10){ //Face cards
            value = 10;
        }
        else{
            value = getValue();
        }
        return value;
    }


    @Override
    public String toString(){
        if(this.isFaceCard()){
            return faceCard + " of " + suit;
        }
        else{
            return value + " of " + suit;
        }
    }

    public String getSuit() {
        return suit;
    }

    public String getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }

}

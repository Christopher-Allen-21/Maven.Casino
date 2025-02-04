package io.zipcoder.casino.CardGame;
import io.zipcoder.casino.Card;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

// Deal 9 cards to player and ai
// Check player hand to see if they have 4 of the same values
// Check ai hand to see if they have 4 of the same values
// While numBooks < 14
//   Display player's hand and prompt user for input
//   Player picks a card to ask for
//      If ai has card, then transfer all cards of that value from ai hand to user hand
//          Check player hand to see if they have 4 of the same values
//              If so then take those cards out of player hand and increase player book num by 1
//      Else card at deckIndex is added to player hand and deckIndex is incremented by 1
//   ai picks random card to ask for
//      If player has card, then transfer all cards of that value from player hand to ai hand
//          Check ai hand to see if they have 4 of the same values
//              If so then take those cards out of the ai hand and increase ai book num by 1
//      Else card at deckIndex is added to ai hand and deckIndex is incremented by 1
// After while loop compare player book num to ai book num; whoever has highest is winner
// Notify who the winner is
// Prompt user to play again or exit back to casino

public class GoFishGame extends CardGame {

    private Console myConsole = new Console(System.in,System.out);
    private Player currentPlayer;
    private Player aiPlayer = new Player("Nobles", 100.0);
    int deckIndex = 0;
    int bookTotal = 0;

    public GoFishGame(Player currentPlayer){
        super();
        this.currentPlayer = currentPlayer;
    }

    public void startGame(){

        while(true){
            resetGame();
            dealCards();
            displayHands();
            checkForBooks();
            while(true){
                while(playerAskForCards()){ }
                if(bookTotal==13){ break;}
                while(aiAskForCards()){ }
                if(bookTotal==13){ break;}
            }
            checkForWinner();
            if(!myConsole.displayPlayAgain("Go Fish")){
                break;
            }
        }
    }

    public void resetGame(){
        deckIndex = 0;
        bookTotal = 0;
        currentPlayer.getSortedHand().clear();
        aiPlayer.getSortedHand().clear();
        Collections.shuffle(deck);
    }

    @Override
    public void dealCards(){
        for(int i=0;i<9;i++){
            currentPlayer.getSortedHand().add(deck.get(deckIndex));
            deckIndex++;

        }
        for(int i=0;i<9;i++){
            aiPlayer.getSortedHand().add(deck.get(deckIndex));
            deckIndex++;
        }
    }

    public void displayHands(){
        myConsole.displayHandAndBooks(deckIndex,currentPlayer.getName(),currentPlayer.getSortedHand(),currentPlayer.getNumBooks(),aiPlayer.getNumBooks(),bookTotal);
        //myConsole.displayHandAndBooks(deckIndex,aiPlayer.getName(),aiPlayer.getSortedHand(),aiPlayer.getNumBooks());
    }

    public void checkForBooks(){
        if(checkHandForBooks(currentPlayer)){
            removeBookAndIncrementNumBooks(currentPlayer,getValueOfBook(currentPlayer));
            myConsole.println("\nPlayer got a book!\n");
            displayHands();
        }
        if(checkHandForBooks(aiPlayer)){
            removeBookAndIncrementNumBooks(aiPlayer,getValueOfBook(aiPlayer));
            myConsole.println("\nNobles got a book!\n");
            displayHands();
        }
    }

    public boolean checkHandForBooks(Player player) {
        boolean hasBook = false;
        HashMap<Integer,Integer> match = new HashMap<>();

        for(int i=2;i<=14;i++){
            match.put(i,0);
        }

        for(int i=0;i<player.getSortedHand().size();i++){
            for(Integer j : match.keySet()){
                if(player.getSortedHand().get(i).getValue()==j){
                    match.put(j,match.get(j)+1);
                }
            }
        }

        for(Integer i : match.keySet()){
            if(match.get(i)==4){
                hasBook = true;
            }
        }

        return hasBook;
    }

    public Integer getValueOfBook(Player player){
        HashMap<Integer,Integer> match = new HashMap<>();
        Integer valueOfBook = -1;

        for(int i=2;i<=14;i++){
            match.put(i,0);
        }

        for(int i=0;i<player.getSortedHand().size();i++){
            for(Integer j : match.keySet()){
                if(player.getSortedHand().get(i).getValue()==j){
                    match.put(j,match.get(j)+1);
                }
            }
        }

        for(Integer i : match.keySet()){
            if(match.get(i)==4){
                valueOfBook = i;
            }
        }
        return valueOfBook;
    }

    public void removeBookAndIncrementNumBooks(Player player, int valueOfMatch){
        ArrayList<Card> cardsToRemove = new ArrayList<>();

        for(int i=0;i<player.getSortedHand().size();i++){
            if(valueOfMatch == player.getSortedHand().get(i).getValue()){
                cardsToRemove.add(player.getSortedHand().get(i));
            }
        }
        player.getSortedHand().removeAll(cardsToRemove);
        player.incrementNumBooks(1);
        bookTotal++;
    }

    public boolean playerAskForCards(){
        if(bookTotal>=13){
            return false;
        }
        Integer cardPicked = myConsole.getCardInput("Enter a card to ask for:");
        myConsole.println("\nPlayer asked for "+cardPicked);

        if(checkHand(aiPlayer,cardPicked)){ //checking AI hand for player card picked
            myConsole.println("Correct!\nPlayer Taking Nobles' Card\n");
            transferCard(aiPlayer,currentPlayer,getValueOfMatch(aiPlayer,cardPicked));//ai player transferring cards to current player
            displayHands();
            checkForBooks();
            return true;
        }
        else{
            if(deckIndex < 52){
                myConsole.println("Incorrect! Go Fish!\nPlayer drawing from deck\n");
                takeCardFromDeck(currentPlayer);
            }
            else{
                myConsole.println("Incorrect! Go Fish!\n");
            }
            displayHands();
            checkForBooks();
            return false;
        }
    }

    public boolean aiAskForCards(){
        if(bookTotal>=13){
            return false;
        }
        Random random  = new Random();
        Integer aiCardPicked = 2 + random.nextInt(14-2+1);

        String playerInput = myConsole.getStringInput("Nobles' turn\nPress any button to continue\n");

        if(playerInput != null){
            if(aiCardPicked>10){
                String faceCardName = convertToFaceCardName(aiCardPicked);
                myConsole.println("Nobles asked for "+faceCardName);
            }
            else{
                myConsole.println("Nobles asked for "+aiCardPicked);
            }

            if(checkHand(currentPlayer, aiCardPicked)){ //checking current player hand for ai card picked
                transferCard(currentPlayer, aiPlayer,getValueOfMatch(currentPlayer,aiCardPicked)); //current player transferring cards to aiPlayer
                myConsole.println("Nobles Taking Player Card\n");
                displayHands();
                checkForBooks();
                return true;
            }
            else{
                if(deckIndex < 52){
                    myConsole.println("Nobles Drawing From Deck\n");
                    takeCardFromDeck(aiPlayer);
                }
                displayHands();
                checkForBooks();
                return false;
            }
        }
        return false;
    }

    public boolean checkHand(Player player, Integer cardValue){
        boolean playerHasCard = false;
        for(int i=0;i<player.getSortedHand().size();i++){
            if(cardValue == player.getSortedHand().get(i).getValue()){
                playerHasCard = true;
                break;
            }
        }
        return playerHasCard;
    }

    public Integer getValueOfMatch(Player player,Integer cardPicked){
        int valueOfMatch = -1;
        for(int i=0;i<player.getSortedHand().size();i++){
            if(cardPicked == player.getSortedHand().get(i).getValue()){
                valueOfMatch=player.getSortedHand().get(i).getValue();
                break;
            }
        }
        return valueOfMatch;
    }

    public void transferCard(Player transferringPlayer, Player receivingPlayer, Integer valueOfMatch){
        ArrayList<Card> cardsToRemove = new ArrayList<>();

        for(int i=0;i<transferringPlayer.getSortedHand().size();i++){
            if(transferringPlayer.getSortedHand().get(i).getValue() == valueOfMatch){ //if value of match equals value of transferring players card
                receivingPlayer.getSortedHand().add(transferringPlayer.getSortedHand().get(i));
                cardsToRemove.add(transferringPlayer.getSortedHand().get(i));
            }
        }
        transferringPlayer.getSortedHand().removeAll(cardsToRemove);
    }

    public void takeCardFromDeck(Player player){
        player.getSortedHand().add(deck.get(deckIndex));
        deckIndex++;
    }

    public String convertToFaceCardName(Integer card){
        if(card == 11){ return "Jack"; }
        else if(card == 12){ return "Queen"; }
        else if(card == 13){ return "King"; }
        else{ return "Ace"; }
    }

    private void checkForWinner() {
        if(currentPlayer.getNumBooks() > aiPlayer.getNumBooks()){
            System.out.println("Congratulations! You Win!\n");
        }
        else{
            System.out.println("You lose! Better luck next time\n");
        }
    }
}

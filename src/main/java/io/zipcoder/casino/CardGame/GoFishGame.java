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
// While deckIndex < NUM_OF_CARDS
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
    private Player aiPlayer = new Player("Nobles");
    int deckIndex = 0;
    int bookTotal = 0;
    boolean lessThanThirteenBooks = true;

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
            while(lessThanThirteenBooks){
                if(bookTotal==13){ lessThanThirteenBooks=false;}
                while(playerAskForCards()){
                    checkForBooks();
                }
                if(bookTotal==13){ lessThanThirteenBooks=false;}
                while(aiAskForCards()){
                    checkForBooks();
                }
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
        currentPlayer.getHand().clear();
        aiPlayer.getHand().clear();
        Collections.shuffle(deck);
    }

    @Override
    public void dealCards(){
        for(int i=0;i<8;i++){
            currentPlayer.getHand().add(deck.get(deckIndex));
            deckIndex++;

        }
        for(int i=0;i<8;i++){
            aiPlayer.getHand().add(deck.get(deckIndex));
            deckIndex++;
        }
    }

    public void displayHands(){
        myConsole.displayHandAndBooks(deckIndex,currentPlayer.getName(),currentPlayer.getHand(),currentPlayer.getNumBooks(),aiPlayer.getNumBooks(),bookTotal);
        //myConsole.displayHandAndBooks(deckIndex,aiPlayer.getName(),aiPlayer.getHand(),aiPlayer.getNumBooks());
    }

    public void checkForBooks(){
        if(checkHandForBooks(currentPlayer)){
            removeBookAndIncrementNumBooks(currentPlayer,getValueOfBook(currentPlayer));
            myConsole.println("\nPlayer got a book!\n");
            displayHands();
        }
        if(checkHandForBooks(aiPlayer)){
            removeBookAndIncrementNumBooks(aiPlayer,getValueOfBook(aiPlayer));
            myConsole.println("\nAI got a book!\n");
            displayHands();
        }
    }

    public boolean checkHandForBooks(Player player) {
        boolean hasBook = false;
        HashMap<Integer,Integer> match = new HashMap<>();

        for(int i=2;i<=14;i++){
            match.put(i,0);
        }

        for(int i=0;i<player.getHand().size();i++){
            for(Integer j : match.keySet()){
                if(player.getHand().get(i).getValue()==j){
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

        for(int i=0;i<player.getHand().size();i++){
            for(Integer j : match.keySet()){
                if(player.getHand().get(i).getValue()==j){
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

        for(int i=0;i<player.getHand().size();i++){
            if(valueOfMatch == player.getHand().get(i).getValue()){
                cardsToRemove.add(player.getHand().get(i));
            }
        }
        player.getHand().removeAll(cardsToRemove);
        player.incrementNumBooks(1);
        bookTotal++;
    }

    public boolean playerAskForCards(){
        Integer cardPicked = myConsole.getCardInput("Enter a card to ask for:");
        myConsole.println("\nPlayer asked for "+cardPicked);

        if(checkHand(aiPlayer,cardPicked)){ //checking AI hand for player card picked
            myConsole.println("Correct!\nPlayer Taking AI Card\n");
            transferCard(aiPlayer,currentPlayer,getValueOfMatch(aiPlayer,cardPicked));//ai player transferring cards to current player
            displayHands();
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
            return false;
        }
    }

    public boolean aiAskForCards(){
        Random random  = new Random();
        Integer aiCardPicked = 2 + random.nextInt(14-2+1);

        String playerInput = myConsole.getStringInput("AI's turn\nPress any button to continue\n");

        if(playerInput != null){
            if(aiCardPicked>10){
                String faceCardName = convertToFaceCardName(aiCardPicked);
                myConsole.println("AI asked for "+faceCardName);
            }
            else{
                myConsole.println("AI asked for "+aiCardPicked);
            }


            if(checkHand(currentPlayer, aiCardPicked)){ //checking current player hand for ai card picked
                transferCard(currentPlayer, aiPlayer,getValueOfMatch(currentPlayer,aiCardPicked)); //current player transferring cards to aiPlayer
                myConsole.println("AI Taking Player Card\n");
                displayHands();
                return true;
            }
            else{
                if(deckIndex < 52){
                    myConsole.println("AI Drawing From Deck\n");
                    takeCardFromDeck(aiPlayer);
                }
                displayHands();
                return false;
            }
        }
        return false;
    }

    public boolean checkHand(Player player, Integer cardValue){
        boolean playerHasCard = false;
        for(int i=0;i<player.getHand().size();i++){
            if(cardValue == player.getHand().get(i).getValue()){
                playerHasCard = true;
                break;
            }
        }
        return playerHasCard;
    }

    public Integer getValueOfMatch(Player player,Integer cardPicked){
        int valueOfMatch = -1;
        for(int i=0;i<player.getHand().size();i++){
            if(cardPicked == player.getHand().get(i).getValue()){
                valueOfMatch=player.getHand().get(i).getValue();
                break;
            }
        }
        return valueOfMatch;
    }

    public void transferCard(Player transferringPlayer, Player receivingPlayer, Integer valueOfMatch){
        ArrayList<Card> cardsToRemove = new ArrayList<>();

        for(int i=0;i<transferringPlayer.getHand().size();i++){
            if(transferringPlayer.getHand().get(i).getValue() == valueOfMatch){ //if value of match equals value of transferring players card
                receivingPlayer.getHand().add(transferringPlayer.getHand().get(i));
                cardsToRemove.add(transferringPlayer.getHand().get(i));
            }
        }
        transferringPlayer.getHand().removeAll(cardsToRemove);
    }

    public void takeCardFromDeck(Player player){
        player.getHand().add(deck.get(deckIndex));
        deckIndex++;
    }

    public String convertToFaceCardName(Integer card){
        if(card == 11){
            return "Jack";
        }
        else if(card == 12){
            return "Queen";
        }
        else if(card == 13){
            return "King";
        }
        else{
            return "Ace";
        }
    }

    private void checkForWinner() {
        if(currentPlayer.getNumBooks() > aiPlayer.getNumBooks()){
            System.out.println("Congratulations! You Win!");
        }
        else{
            System.out.println("You lose! Better luck next time");
        }
    }
}

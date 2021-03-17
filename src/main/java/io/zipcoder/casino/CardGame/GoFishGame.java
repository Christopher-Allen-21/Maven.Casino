package io.zipcoder.casino.CardGame;
import io.zipcoder.casino.Card;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Collections;
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

    public GoFishGame(Player currentPlayer){
        super();
        this.currentPlayer = currentPlayer;
    }

    public void startGame(){
        /*
        dealCards()
        checkPlayerHandForBooks()
        checkAIHandForBooks()
        while(deckIndex > NUM_OF_CARDS){
            do{
                displayPlayerHand()
                promptUserForInput()
                    if(aiHasCard){
                        transferCardsFromAIToPlayer()
                        checkPlayerHandForBooks()
                    }
                    else{
                        transferCardFromDeckToPlayer()
                        deckIndex++
                        playerGuessIsCorrect = false
                    }
            }while(aiGuessIsCorrect)
            do{
                 aiGuessCard()
                 displayAIGuess()
                 displayPlayerHand()
                    if(userHasCard){
                        transferCardsFromPlayerToAI()
                        checkAIHandForBooks()
                    }
                    else{
                        transferCardFromDeckToAI()
                        deckIndex++
                        AIGuessIsCorrect = false
                    }
            }while(playerGuessIsCorrect)
         */

        while(true){
            resetGame();
            dealCards();
            myConsole.displayHandAndBooks(deckIndex,currentPlayer.getName(),currentPlayer.getHand(),currentPlayer.getNumBooks());
            myConsole.displayHandAndBooks(deckIndex,aiPlayer.getName(),aiPlayer.getHand(),aiPlayer.getNumBooks());
            checkForBooks();
            while(deckIndex<51){
                playerAskForCards();
                myConsole.displayHandAndBooks(deckIndex,currentPlayer.getName(),currentPlayer.getHand(),currentPlayer.getNumBooks());
                myConsole.displayHandAndBooks(deckIndex,aiPlayer.getName(),aiPlayer.getHand(),aiPlayer.getNumBooks());
                aiAskForCards();
                myConsole.displayHandAndBooks(deckIndex,currentPlayer.getName(),currentPlayer.getHand(),currentPlayer.getNumBooks());
                myConsole.displayHandAndBooks(deckIndex,aiPlayer.getName(),aiPlayer.getHand(),aiPlayer.getNumBooks());
                checkForBooks();
            }


            if(!myConsole.displayPlayAgain("Go Fish")){
                break;
            }

        }
    }

    public void resetGame(){
        deckIndex = 0;
        currentPlayer.getHand().clear();
        aiPlayer.getHand().clear();
        Collections.shuffle(deck);
    }

    @Override
    public void dealCards(){
        for(int i=0;i<9;i++){
            currentPlayer.getHand().add(deck.get(deckIndex));
            deckIndex++;

        }
        for(int i=0;i<9;i++){
            aiPlayer.getHand().add(deck.get(deckIndex));
            deckIndex++;
        }
    }

    public void checkForBooks(){
        if(checkHandForBooks(currentPlayer)){
            removeBookAndIncrementNumBooks(currentPlayer,getIndexOfBook(currentPlayer));
            myConsole.println("\nPlayer got a book!\n");
            myConsole.displayHandAndBooks(deckIndex,currentPlayer.getName(),currentPlayer.getHand(),currentPlayer.getNumBooks());
        }
        if(checkHandForBooks(aiPlayer)){
            removeBookAndIncrementNumBooks(aiPlayer,getIndexOfBook(aiPlayer));
            myConsole.println("\nAI got a book!\n");
            myConsole.displayHandAndBooks(deckIndex,currentPlayer.getName(),currentPlayer.getHand(),currentPlayer.getNumBooks());
        }
    }

    public boolean checkHandForBooks(Player player) {
        boolean hasBook = false;
        for(int i=0;i<player.getHand().size();i++){
            if(Collections.frequency(player.getHand(),player.getHand().get(i))==4){
                hasBook = true;
            }
        }
        return hasBook;
    }

    public int getIndexOfBook(Player player){
        int indexOfBook = -1;
        for(int i=0;i<player.getHand().size();i++){
            if(Collections.frequency(player.getHand(),i)==4){
                indexOfBook = i;
                break;
            }
        }
        return indexOfBook;
    }

    public void removeBookAndIncrementNumBooks(Player player, int indexOfBook){
        int valueAtIndex = player.getHand().get(indexOfBook).getValue();
        for(int i=0;i<player.getHand().size();i++){
            if(valueAtIndex == player.getHand().get(i).getValue()){
                player.getHand().remove(i);
            }
        }
        currentPlayer.incrementNumBooks(1);
    }

    public void playerAskForCards(){
        Integer cardPicked = myConsole.getCardInput("Enter a card to ask for:");
        myConsole.println("\nPlayer asked for "+cardPicked);

        if(checkHand(aiPlayer,cardPicked)){
            myConsole.println("Player Taking AI Card\n");
            transferCardFromAIToPlayer(cardPicked);
        }
        else{
            myConsole.println("Player drawing from deck\n");
            takeCardFromDeck(currentPlayer);
        }

    }

    public void transferCardFromAIToPlayer(Integer cardValue){
        for(int i=0;i<aiPlayer.getHand().size();i++){
            if(cardValue == aiPlayer.getHand().get(i).getValue()){
                currentPlayer.getHand().add(aiPlayer.getHand().get(i));
                aiPlayer.getHand().remove(i);
            }
        }
    }

    public void transferCardFromPlayerToAi(Integer cardValue){
        for(int i=0;i<currentPlayer.getHand().size();i++){
            if(cardValue == currentPlayer.getHand().get(i).getValue()){
                aiPlayer.getHand().add(currentPlayer.getHand().get(i));
                currentPlayer.getHand().remove(i);
            }
        }
    }

    public void takeCardFromDeck(Player player){
        player.getHand().add(deck.get(deckIndex));
        deckIndex++;
    }

    public void aiAskForCards(){
        Random random  = new Random();
        Integer aiCardPicked = 2 + random.nextInt(14-2+1);
        myConsole.println("AI asked for "+aiCardPicked);

        if(checkHand(currentPlayer, aiCardPicked)){
            transferCardFromPlayerToAi(aiCardPicked);
            myConsole.println("AI Taking Player Card\n");
        }
        else{
            myConsole.println("AI Drawing From Deck\n");
            takeCardFromDeck(aiPlayer);
        }
    }



    public boolean checkHand(Player player, Integer cardValue){
        boolean playerHasCard = false;
        for(int i=0;i<player.getHand().size();i++){
            if(cardValue == player.getHand().get(i).getValue()){
                playerHasCard = true;
            }
        }
        return playerHasCard;
    }

    public void compareNumBooks(){}
    public void passPlayCard(){}

    public void checkWinner() {

    }


}

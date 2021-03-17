package io.zipcoder.casino.CardGame;
import io.zipcoder.casino.Card;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;
import java.util.Collections;

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
            deckIndex = 0;
            Collections.shuffle(deck);
            dealCards();
            myConsole.displayHandAndBooks(currentPlayer.getHand(),currentPlayer.getNumBooks());
            if(checkHandForBooks(currentPlayer)){
               removeBook(currentPlayer,getIndexOfBook(currentPlayer));
            }




        }
    }

    public boolean checkHandForBooks(Player player) {
        boolean hasBook = false;
        for(int i=0;i<player.getHand().size();i++){
            if(Collections.frequency(player.getHand(),i)==4){
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

    public void removeBook(Player player, int indexOfBook){
        int valueAtIndex = player.getHand().get(indexOfBook).getValue();
        for(int i=0;i<player.getHand().size();i++){

        }
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

    public void playerAskForCards(){
        myConsole.displayHandAndBooks(currentPlayer.getHand(),currentPlayer.getNumBooks());
        Integer cardPicked = myConsole.getCardInput("Ask opposing player for a card:",currentPlayer.getHand().toArray());
        if(checkAIHand(cardPicked)){

        }

    }

    public void aiAskForCards(){

    }

    public boolean checkAIHand(Integer cardValue){
        boolean aiHasCard = false;
        for(int i=0;i<aiPlayer.getHand().size();i++){
            if(cardValue == aiPlayer.getHand().get(i).getValue()){
                aiHasCard = true;
            }
        }
        return aiHasCard;
    }

    public void compareNumBooks(){}
    public void passPlayCard(){}

    public void checkWinner() {

    }

    public void resetGame(){

    }
}

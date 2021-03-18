package io.zipcoder.casino.CardGame;
import io.zipcoder.casino.GameInterface.GamblingGameInterface;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;
import java.util.Collections;
import java.util.Objects;


public class BlackJack extends CardGame implements GamblingGameInterface {
    private Console console = new Console(System.in,System.out);
    int deckIndex = 0;
    Player player1;
    Player dealer1 = new Player("Nobles");
    Player dealer2 = new Player("Dolio");
    Player dealer3 = new Player("Younger");
    boolean gameOn = true;
    boolean hit = true;

    public BlackJack(Player player1) {
        super();
        this.player1 = player1;
    }


    public void startGame() {
        while(gameOn) {
            resetGame();
            Collections.shuffle(deck);
            dealCards();
            getPlayerTotals();
            getDealerTotal();
            console.checkPlayerHand(player1.getName(), player1.getHand(), player1.getHandTotal());
            console.checkPlayerHand(dealer1.getName(), dealer1.getHand(), dealer1.getHandTotal());
            if (player1.getHandTotal() != 21) {
                do {
                    checkIfPlayerHit();
                    if (player1.getHandTotal() > 21) {
                        System.out.println("Bust");
                        break;
                    }
                }while(hit);
            }
            dealerAI();
            checkWinner();
            hit = true;
            gameOn = console.displayPlayAgain("BlackJack");
        }
    }

    public void resetGame(){
        deckIndex = 0;
        player1.setHandTotal(0);
        player1.getHand().clear();
        dealer1.setHandTotal(0);
        dealer1.getHand().clear();
    }

    public void checkIfPlayerHit (){
        if (Objects.equals(console.askHitOrStay(), "hit")) {
            addCard();
           aceCheck(player1);
            getPlayerTotals();
            console.checkPlayerHand(player1.getName(),player1.getHand(), player1.getHandTotal());
        }
        else if(Objects.equals(console.askHitOrStay(), "stay")) {
            hit = false;
        }
    }


    public void dealerAI(){
        while(dealer1.getHandTotal() <=18) {
            dealer1.getHand().add(deck.get(deckIndex));
            deckIndex++;
            getDealerTotal();
            //aceCheck(dealer1);
            console.checkPlayerHand(dealer1.getName(), dealer1.getHand(), dealer1.getHandTotal());
        }
    }


    public void aceCheck(Player player){
        int total = 0;
        for(int i = 0; i < player.getHand().size(); i++){
            if(player.getHand().indexOf(i) == 11 && player.getHandTotal() > 21){
                total = player.getHandTotal() - 10;
                break;
            }
        }
        player.setHandTotal(total);
    }


    public void getDealerTotal(){
        int total = 0;
        for(int i = 0; i < dealer1.getHand().size(); i++){
            total += dealer1.getHand().get(i).getBlackJackValue();
        }
        dealer1.setHandTotal(total);
    }


    public void getPlayerTotals () {
        int total = 0;
        for(int i = 0; i < player1.getHand().size(); i++){
            total += player1.getHand().get(i).getBlackJackValue();
        }
        player1.setHandTotal(total);
    }


    public void playerLosesBet () {
    }
    public void playerWinsBet () {
    }
    public void playerHasNoMoney () {
    }


    public void checkWinner () {
        if((player1.getHandTotal() > dealer1.getHandTotal())   && player1.getHandTotal() < 22) {
            System.out.println(player1.getName() + " Wins");
        }
        else if(player1.getHandTotal() < 22 && dealer1.getHandTotal() > 21){
            System.out.println(player1.getName() +" Wins");
        }

        else if((dealer1.getHandTotal() > player1.getHandTotal())   && dealer1.getHandTotal() < 22) {
            System.out.println(player1.getName() + " Wins");
        }
        else if(dealer1.getHandTotal() < 22 && player1.getHandTotal() > 21){
            System.out.println(dealer1.getName()+" Wins");
        }
        else if((player1.getHandTotal() == dealer1.getHandTotal()) ||
                (player1.getHandTotal() > 21 && dealer1.getHandTotal() > 21) ){
            System.out.println("\nPush");
        }
        gameOn = false;

    }

    public void dealCards(){

        while(player1.getHand().size() < 2) {
            player1.getHand().add(deck.get(deckIndex));
            deckIndex++;
        }
        while (dealer1.getHand().size() < 2) {
            dealer1.getHand().add(deck.get(deckIndex));
            deckIndex++;
        }

    }

    public void addCard(){
        player1.getHand().add(deck.get(deckIndex));
        deckIndex++;
        if(player1.getHandTotal() > 21){
            checkWinner();
        }
    }
}


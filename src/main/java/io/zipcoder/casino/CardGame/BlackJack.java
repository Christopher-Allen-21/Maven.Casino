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
    Player dealer1 = new Player("Nobles", 100.0);
    Player dealer2 = new Player("Dolio",100.0);
    Player dealer3 = new Player("Younger", 100.0);
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
            getPlayerTotal(player1);
            getPlayerTotal(dealer1);
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
            getPlayerTotal(player1);
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
            getPlayerTotal(dealer1);
            console.checkPlayerHand(dealer1.getName(), dealer1.getHand(), dealer1.getHandTotal());
        }
    }


    public void getPlayerTotal(Player player){
        int total = 0;
        for(int i = 0; i < player.getHand().size(); i++){
            if(player.getHand().get(i).getBlackJackValue() == 14 && total + 11 > 21) {
                total += 1;
            }
            else if(player.getHand().get(i).getBlackJackValue() == 14){
                total += 11;
            }
            else
            total += player.getHand().get(i).getBlackJackValue();
        }
        player.setHandTotal(total);
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


package io.zipcoder.casino.CardGame;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.Player.Player;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Random;

public class GoFishGameTest extends TestCase {

    public void testStartGame() {
    }

    public void testDealCards() {
    }

    public void testPlayerAskForCards() {
    }

    public void testAiAskForCards() {
    }

    public void testCheckAIHand() {
    }

    public void testCompareNumBooks() {
    }

    public void testPassPlayCard() {
    }

    public void testCheckWinner() {
    }

    public void testResetGame() {
    }

    public void testCheckPlayerHandForBooks() {
        Player player1 = new Player("Bob");
        ArrayList<Card> hand = new ArrayList<>() ;

    }


    public void testAIAskForCards(){
        Player player1 = new Player("Chris");
        GoFishGame game = new GoFishGame(player1);
        for(int i=0;i<1000;i++){
            //System.out.println(game.aiAskForCards());
        }
    }
}
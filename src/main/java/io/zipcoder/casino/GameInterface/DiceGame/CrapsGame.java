package io.zipcoder.casino.GameInterface.DiceGame;
import io.zipcoder.casino.GameInterface.GamblingGameInterface;
import io.zipcoder.casino.GameInterface.GamblingGameInterface;
import io.zipcoder.casino.Player.Player;

public class CrapsGame extends DiceGame implements GamblingGameInterface {

    // User makes a bet
    //      User bets on pass line or don't pass line
    //      User makes non-field bet (betting first roll will be 6 or 8 [9 to 1 payout], 4 or 10 [7 to 1 payout], 2 or 12 [30 to 1 payout], 3 or 11 [15 to 1 payout], craps?
    //      First roll of game (come out roll)
    //          if(dice roll = 7 or 11)
    //              betting on pass -> user wins
    //              betting on don't pass -> user loses
    //          else if(dice roll = 2,3,12)
    //              betting on pass -> user loses
    //              betting on don't pass -> user wins
    //          else (4,5,6,8,9,10)
    //              point = dice roll
    //              go to second part of game
    //
    ///
    //  SECOND PART OF game
    //     User makes bet
    //
    //           keep rolling
    //              Bet on come line
    //                  betting they get point again before 7
    //              bet on don' come line
    //                  betting the point doens't come before 7
    //
    //          Field bet (1 roll bet; can only happen in second part of game) -> on next roll, user BETTIGN THEY'LL GET 2,3,4,9,10,11,12 (1 to 1 if 3 through 11) (pays out 2-1 if 2 or 12)
    //          Non-field bets (1 roll bet; can happen at any time) -> betting they'll get one number that they chose
    //
    //          place bets (not a 1 roll bet; can only happen in second part of game) -> don't think they're going to roll point before 7 (picking one of these 4,5,6,8,9,10 that must come before point)

    /*
      makeBets()
            passLine
            dontPassLine
            nonFieldBet
            makeAnotherBet()?
     while(not 4,5,6,8,9,10)
        reset()
        rollDice()
        compareBetsToDiceRoll()
        payOutOrTakeMoney()
      while(secondRoll != 7)
        makeBets()
            comeLine
            dontComeLine
            fieldBet
            nonFieldBet
            placeBet
            makeAnotherBet()?
        rollDice()
        compareBetsToDiceRoll()
        payOutOrTakeMoney()
     */

    int point;

    public CrapsGame(Player player1){
        super();
    }

    public void startGame(){

    }




    public void playerLosesBet() {
    }

    public void playerWinsBet(){
    }

    public void playerHasNoMoney(){
    }

    public void checkWinner(){
    }

}

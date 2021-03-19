package io.zipcoder.casino;

import io.zipcoder.casino.Player.Player;
import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {


    @Test
    public void getNameTest(){
        //Arrange
        Player player = new Player("Name",1000.0);

        //Action
        String expected = "Name";
        String actual = player.getName();

        //Assertion
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getPlayerBalanceTest(){
        //Arrange
        Player player = new Player("Name",1000.0);

        //Action
        double expected = 1000.0;
        double actual = player.getPlayerBalance();

        //Assertion
        Assert.assertEquals(expected,actual,0.01);
    }
    @Test
    public void setPlayerBalanceTest(){
        //Arrange
        Player player = new Player("Name",0.0);

        //Action
        player.setPlayerBalance(1000.0);
        double expected = 1000.0;
        double actual = player.getPlayerBalance();

        //Assertion
        Assert.assertEquals(expected,actual,0.01);
    }
    @Test
    public void setPlayerBetTest() {
        //Arrange
        Player player = new Player("Name", 0.0);

        //Action
        player.setPlayerBalance(1000.0);
        double expected = 1000.0;
        double actual = player.getPlayerBalance();

        //Assertion
        Assert.assertEquals(expected, actual, 0.01);
    }

}

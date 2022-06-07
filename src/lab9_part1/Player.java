/*
 * Programmer: Decknadel, Alex
 * Chemeketa Community College
 * February 4, 2019
 * Class: CIS233J
 * Assignment: Dice Games
 * File Name: Player.java
 */
package lab9_part1;

/**
 * Purpose: This class creates a dice game player.
 *
 * @author <a href= "mailto:adeckna1@my.chemeketa.edu" >Alex Decknadel</a>
 */
public class Player 
{
    protected int totalPoints;
    protected int roundPoints;
    protected int roundLimit;
    protected final int LIMIT = 20;
    
    public Player() 
    {
        totalPoints = 0;
        roundPoints = 0;
        roundLimit = 0;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getRoundPoints() {
        return roundPoints;
    }

    public void setRoundPoints(int roundPoints) {
        this.roundPoints = roundPoints;
    }

    public int getRoundLimit() {
        return roundLimit;
    }

    public void setRoundLimit(int roundLimit) {
        this.roundLimit = roundLimit;
    }

    @Override
    public String toString() {
        String player = "";
        player += "Total Points = " + totalPoints 
                + " Round Points=" + roundPoints;
        return player;
    }

    
    
    
}

/*
 * Programmer: Decknadel, Alex
 * Chemeketa Community College
 * February 4, 2019
 * Class: CIS233J
 * Assignment: Dice Games
 * File Name: PigPlayer.java
 */
package lab9_part1;

/**
 * Purpose: This class creates Pig players and a pair of dice for Pig.
 *
 * @author <a href= "mailto:adeckna1@my.chemeketa.edu" >Alex Decknadel</a>
 */
public class PigPlayer extends Player 
{
    // declare players and pair of dice
    Player human, computer, currentPlayer;
    PairOfDice dice;
    
    /**
     * Purpose: Creates and initializes players and dice for a game of Pig.
     */
    public PigPlayer() 
    {
        computer = new Player();
        human = new Player();
        currentPlayer = new Player();
        dice = new PairOfDice();
    }
}

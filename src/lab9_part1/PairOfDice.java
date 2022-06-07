/*
 * Programmer: Decknadel, Alex
 * Chemeketa Community College
 * January 30, 2019
 * Class: CIS233J
 * Assignment: Dice Games
 * File Name: PairOfDice.java
 */
package lab9_part1;

/**
 * Purpose: This class defines a pair of dice.
 *
 * @author <a href= "mailto:adeckna1@my.chemeketa.edu" >Alex Decknadel</a>
 */
public class PairOfDice
{

    Die die1, die2; // declare Die objects

    /**
     * Purpose: This method instantiates a pair of 6-faced dice.
     */
    public PairOfDice()
    {
        die1 = new Die();
        die2 = new Die();
    }

    /**
     * Purpose: This method instantiates a pair of dice with a different number
     * of faces.
     */
    public PairOfDice(int faces)
    {
        die1 = new Die(faces);
        die2 = new Die(faces);
    }

    /**
     * Purpose: This method calls the roll method in Die.java to change the face
     * value of each die.
     */
    public void rollDice()
    {
        die1.roll();
        die2.roll();
    }

    /**
     * Purpose: This method determines if a roll has boxcars.
     */
    public boolean boxcars()
    {
        if (die1.getFaceValue() == 6 && die2.getFaceValue() == 6)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Purpose: This method counts the number of snake eyes in a set of rolls.
     */
    public boolean snakeEyes()
    {
        if (die1.getFaceValue() == 1 && die2.getFaceValue() == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Purpose: This method gets the face value of Die1.
     */
    public int getDieOne()
    {
        int firstDie = die1.getFaceValue();
        return firstDie;
    }

    /**
     * Purpose: This method gets the face value of Die2.
     */
    public int getDieTwo()
    {
        int secondDie = die2.getFaceValue();
        return secondDie;
    }
}

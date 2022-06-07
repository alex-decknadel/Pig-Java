/*
 * Programmer: Decknadel, Alex
 * Chemeketa Community College
 * January 30, 2019
 * Class: CIS233J
 * Assignment: Dice Games
 * File Name: Die.java
 */
package lab9_part1;

/**
 * Purpose: This class defines a single die object.
 *
 * @author <a href= "mailto:adeckna1@my.chemeketa.edu" >Alex Decknadel</a>
 */
public class Die
{

    private final int MIN_FACES = 4;
    /**
     * number of sides on the die
     */
    private int numFaces;
    /**
     * current value showing on the die
     */
    private int faceValue;

    /**
     * This constructor creates a Die object and defaults to a six-sided die,
     * with the face showing 1.
     */
    public Die()
    {
        numFaces = 6;
        faceValue = 1;
    }

    /**
     * This constructor explicitly sets the size of the die. Defaults to a size
     * of six if the parameter is invalid. Initial face value is 1.
     *
     * @param faces Number of faces desired.
     * @return Returns a single Die object with the number of faces passed in a
     * a parameter.
     */
    public Die(int faces)
    {
        if (faces < MIN_FACES)
        {
            numFaces = 6;
        } 
        else
        {
            numFaces = faces;
        }
        faceValue = 1;
    }

    /**
     * Rolls the die and returns the result.
     *
     * @return Returns the randomly set face value of the die.
     */
    public int roll()
    {
        faceValue = (int) (Math.random() * numFaces) + 1;
        return faceValue;
    }

    /**
     * Returns the current die value.
     *
     * @return Returns the current die value.
     */
    public int getFaceValue()
    {
        return faceValue;
    }

    /**
     * Sets the faceValue of the Die
     * @param faceValue Value to set the faceValue to.
     */
    public void setFaceValue(int faceValue)
    {
        this.faceValue = faceValue;
    }

    @Override
    public String toString()
    {
        return "Die face value = " + faceValue;
    }

}

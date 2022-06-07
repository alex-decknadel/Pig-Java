/*
 * Programmer: Decknadel, Alex
 * Chemeketa Community College
 * February 4, 2019
 * Class: CIS233J
 * Assignment: Dice Games - Pig
 * File Name: PlayPig.java
 */
package lab9_part1;

import java.util.Scanner;

/**
 * Purpose: This class runs a game of Pig.
 *
 * @author <a href= "mailto:adeckna1@my.chemeketa.edu" >Alex Decknadel</a>
 */
public class PlayPig
{
    public static void main(String[] args)
    {   
        // creates a new instance of Pig and runs the game
        Pig pig = new Pig();
        pig.play();
        
    }
}

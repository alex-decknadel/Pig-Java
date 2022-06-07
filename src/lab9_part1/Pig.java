/*
 * Programmer: Decknadel, Alex
 * Chemeketa Community College
 * February 4, 2019
 * Class: CIS233J
 * Assignment: Dice Games
 * File Name: Pig.java
 */
package lab9_part1;

import java.util.Scanner;

/**
 * Purpose: This class determines how a game of Pig is played.
 *
 * @author <a href= "mailto:adeckna1@my.chemeketa.edu" >Alex Decknadel</a>
 */
public class Pig extends PigPlayer
{
    // declares inputs for the game
    String input;
    String turnInput;

    Scanner scan = new Scanner(System.in);

    /**
     * Purpose: Calls upon the class PigPlayer to get players for Pig.
     */
    public Pig()
    {
        super();
    }

    /**
     * Purpose: Runs a game of Pig by calling on other methods.
     */
    public void play()
    {
        // asks the user if they want to play
        System.out.print("Would you like to play a game of "
                + "pig? (Y)es or (N)o? ");
        input = scan.next();
        System.out.println("");

        // a game of Pig, loops if the player wants to play another game
        while (input.equalsIgnoreCase("y"))
        {
            // user gets first turn
            currentPlayer = human;

            // computer can't roll after they get 20 points in a round
            computer.setRoundLimit(LIMIT);

            // sets the points for both players to 0
            computer.totalPoints = 0;
            human.totalPoints = 0;

            // the players will play until one of them reaches a score of 100
            while (human.totalPoints < 100 && computer.totalPoints < 100)
            {
                // sets the current player's points in the round to 0
                currentPlayer.setRoundPoints(0);

                // this is what happens during the user's turns
                if (currentPlayer == human)
                {
                    // initializes turnInput to proceed with player's turn
                    turnInput = "y";

                    // user will roll whenever the player chooses to roll
                    while (turnInput.equalsIgnoreCase("y"))
                    {
                        // rolls the dice and checks roll
                        checkRoll(rollEm());

                        // will stop turn if the user rolls a 1 or snake eyes
                        if (dice.snakeEyes() == true
                                || dice.getDieOne() == 1
                                || dice.getDieTwo() == 1)
                        {
                            break;
                        }

                        // determines if user will roll again
                        userTurn();
                    }
                }
                else
                {
                    // proceeds with the computer's turn
                    computerTurn();
                }
            }

            // when game is over, this will display the results
            results();

            // asks the user if they want to play again
            System.out.print("Do you want to play again? (Y)es or (N)o?? ");
            input = scan.next();

        }

        // parting message when user quits the game
        System.out.println("Goodbye.");
    }

    /**
     * Purpose: Checks the roll of the dice to see if a 1 or snake eyes was
     * rolled. If not, then adds points to the player's points earned that turn.
     */
    public void checkRoll(int[] array)
    {
        // displays the roll
        System.out.println("The roll had a " + dice.getDieOne()
                + " and a " + dice.getDieTwo() + ".");

        // determines what happens when player rolls snake eyes
        if (dice.snakeEyes() == true)
        {

            // determines the message when the player is the user
            if (currentPlayer == human)
            {
                System.out.println("You lose all of your points "
                        + "and your turn. \n");
            }

            // determines the message when the player is the computer
            else
            {
                System.out.println("Your opponent loses all of their points "
                        + "and their turn. \n");
            }

            // set the points that turn and total score to 0
            currentPlayer.setRoundPoints(0);
            currentPlayer.totalPoints = 0;

            // switches to the next player
            switchPlayer(currentPlayer);
        }

        // determines what happens when one of the die rolls a 1
        else if (dice.getDieOne() == 1 || dice.getDieTwo() == 1)
        {

            // determines the message when the player is the user
            if (currentPlayer == human)
            {
                System.out.println("You lose your turn and the "
                        + "points you earned this turn. \n");
            }

            // determines the message when the player is the computer
            else
            {
                System.out.println("Your opponent loses their turn "
                        + "and the points they earned this turn. \n");
            }

            // set the points that turn and total score to 0
            currentPlayer.setRoundPoints(0);

            // switches to the next player
            switchPlayer(currentPlayer);

        }

        // determines what happens when the player didn't roll a 
        // 1 or snake eyes
        else
        {
            currentPlayer.roundPoints += dice.getDieOne() + dice.getDieTwo();
        }
    }

    /**
     * Purpose: Rolls the dice and returns an array.
     */
    public int[] rollEm()
    {
        int[] twoDie = new int[2];
        dice.rollDice();
        twoDie[0] = dice.getDieOne();
        twoDie[1] = dice.getDieTwo();
        return twoDie;
    }

    /**
     * Purpose: Switches the player when one's turn is over.
     */
    public void switchPlayer(Player current)
    {
        // switches to the user if the current player is the computer
        if (current != human)
        {
            currentPlayer = human;
            currentPlayer.setRoundPoints(0);
        }
        // switches to the computer if the current player is the user
        else
        {
            currentPlayer = computer;
            currentPlayer.setRoundPoints(0);
        }
    }

    /**
     * Purpose: Asks the user if they want to roll again. If not, it'll add the
     * points earned to their score and pass to the next player.
     */
    public void userTurn()
    {
        // asks 
        System.out.print("Would you like to roll again? ");
        turnInput = scan.next();
        System.out.println("");

        if (!turnInput.equalsIgnoreCase("y"))
        {
            currentPlayer.totalPoints += currentPlayer.roundPoints;

            System.out.println("You earned " + human.roundPoints
                    + " that round!");
            System.out.println("Your current score is: "
                    + human.totalPoints + "\n");
            switchPlayer(currentPlayer);
        }
    }

    /**
     * Purpose: Creates players and dice for a game of Pig.
     */
    public void computerTurn()
    {
        // computer will roll the dice until it earns 20 or more points
        while (computer.roundPoints < computer.roundLimit)
        {
            // rolls the dice and checks roll
            checkRoll(rollEm());

            // stops turn if player rolls a 1 or snake eyes
            if (dice.snakeEyes() == true
                    || dice.getDieOne() == 1
                    || dice.getDieTwo() == 1)
            {
                break;
            }

            // stops the turn if the computer goes over 20
            if (computer.roundPoints > computer.roundLimit)
            {
                computer.totalPoints += computer.roundPoints;
                System.out.println("Your opponent earned "
                        + computer.roundPoints + " this turn.");
                System.out.println("They currently have "
                        + computer.totalPoints + " points. \n");
                switchPlayer(currentPlayer);
            }

        }
    }

    /**
     * Purpose: Shows the results of the game.
     */
    public void results()
    {
        // the user wins if they reach 100 first
        if (human.totalPoints >= 100)
        {
            System.out.println("You win! You earned " + human.totalPoints
                    + " this game.");
        }
        // the computer wins if it reaches 100 first
        else
        {
            System.out.println("Sorry, but it looks like you lost this "
                    + "game. Your opponent scored " + computer.totalPoints
                    + " this game. \n");
        }
    }
}

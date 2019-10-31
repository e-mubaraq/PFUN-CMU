package hw3;

import java.io.*;
import java.util.*;

/**
 * This class simulates a guessing game by utilizing the Random class.
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */

public class GuessTheNumber
{
    static Random r = new Random();

    public static void main(String[] argv) throws IOException
    {
        int maxRange;
        int num_of_times;
        int bigO;
        String name;
        String replay;

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        maxRange = 1 + r.nextInt(1000);
        name = promptForName(keyboard);

        System.out.print("Do you want to play my Guess the number Game: ");
        replay = keyboard.readLine();

        while (isYes(replay) || isBlank(replay))
        {
            System.out.print("Hi " + name + ", I am thinking of a number from 1-" + maxRange + " - guess the number:");

            num_of_times = guess(keyboard, maxRange);
            bigO = log2(maxRange);

            if (num_of_times <= bigO)
                System.out.println("You know the secret!");
            else
                System.out.println("You should be able to do better!");

            System.out.println("Congratulations, you guessed the number!");
            System.out.println("Thanks for playing my Guess-the-Number Game " + name + "!");

            System.out.print("Do you want to play again: ");
            replay = keyboard.readLine();
            maxRange = 1 + r.nextInt(1000); // this ensures the maximum range for the next game is random.
        }
    }

    /**
     * This method helps us track the number of time(s) the player guesses before
     * making the right guess.
     * 
     * @param keyboard variable used for getting input from the keyboard
     * @param maxRange Guessing limit, range to be guessed from.
     * @return number of times the player guesses before making the right guess.
     * @throws IOException
     */
    public static int guess(BufferedReader keyboard, int maxRange) throws IOException
    {
        int number_of_tries = 0;
        int number;
        int guess;
        String str;

        number = 1 + r.nextInt(maxRange); // generates number to be guessed.

        while (true)
        {
            number_of_tries++;
            str = keyboard.readLine();
            guess = Integer.parseInt(str);

            if (guess == number)
                break;
            if (guess < number)
                System.out.print("Too Low.");
            else
                System.out.print("Too High.");
            System.out.print("Try again.");
        }
        return number_of_tries;
    }

    /**
     * This method calculates the maximum number of times a player needs to make a
     * correct guess.
     * 
     * @param n Maximum range a player is guessing from
     * @return maximum number of times a player needs to make a correct guess.
     */
    public static int log2(int n)
    {
        int log = 0;
        log = (int) Math.round(Math.log10(n) / Math.log10(2.));

        return log;
    }

    /**
     * This method prompts for name of the player.
     * 
     * @param keyboard used for prompting for the name of the player
     * @return Players's name
     * @throws IOException
     */
    public static String promptForName(BufferedReader keyboard) throws IOException
    {
        String name;
        System.out.print("Please enter your name: ");
        name = keyboard.readLine();

        return name;
    }

    /**
     * Checks if the string is a space or any space character.
     * 
     * @param answer String to be checked
     */
    public static boolean isBlank(String answer)
    {
        if (answer.replaceAll("[\\p{Space}]", "").equals(""))
            return true;

        return false;
    }

    /**
     * Checks if the string is yes, y or yep.
     * 
     * @param answer String to be checked
     */
    public static boolean isYes(String answer)
    {
        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yep"))
            return true;

        return false;
    }
}

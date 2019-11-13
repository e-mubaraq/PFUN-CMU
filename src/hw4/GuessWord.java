package hw4;
import java.io.*;
import java.util.*;



/**
 * This program runs a guess word game
 *
 * @author Mubarak Mikail
 * 
 * @author Ozioma Paul
 * 
 * Andrew ID: mmikail 
 * 
 * Andrew ID: pozioma
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */

public class GuessWord
{
    public static void main(String[] args) throws IOException
    {
        String filename;
        String input;
        String randomPhrase;

        if (args.length == 0)
            filename = "names.txt";
        else
            filename = args[0];

        PhraseList listOfPhrases = new PhraseList(filename);
        SecretString secretPhrase = new SecretString();

        System.out.println("***********************************************");
        System.out.println("Welcome to Mubarak's and Ozioma's fabulous word-guessing game!");
        System.out.println("***********************************************");

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Would you like to play?");
        input = keyboard.readLine();

        while (checkForYes(input))
        {
            randomPhrase = listOfPhrases.getRandomPhrase();
            secretPhrase.setSecretPhrase(randomPhrase);

            guessPhrase(secretPhrase, keyboard);

            System.out.println("Would you like to play again?");
            input = keyboard.readLine();
        }
    }

    public static void guessPhrase(SecretString secret, BufferedReader keyboard) throws IOException
    {
        int tries = 0;
        int letterCount = 0;
        String guess;
        String guessLetter;

        System.out.println("Guess the phrase: ");
        guess = keyboard.readLine();
        tries = tries + 1;

        if (secret.equals(guess))
        {
            System.out.println("Yes, that's it! You guessed it in " + tries + " tries!");
        }

        while (!secret.equals(guess))
        {
            System.out.println("No, that's not it.");
            System.out.println("Guess a letter: ");
            guessLetter = keyboard.readLine();

            letterCount = secret.reveal(guessLetter);
            System.out.println("There are " + letterCount + " \"" + guessLetter + "\" " + "s");
            System.out.println(secret);

            System.out.println("Guess the phrase: ");
            guess = keyboard.readLine();
            tries = tries + 1;

            if (secret.equals(guess))
            {
                System.out.println("Yes, that's it! You guessed it in " + tries + " tries!");
                break;
            }
        }
    }

    public static boolean checkForYes(String response)
    {
        if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("yep"))
            return true;

        else
            return false;
    }
}
